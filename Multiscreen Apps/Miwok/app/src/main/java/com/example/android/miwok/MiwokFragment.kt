package com.example.android.miwok

import android.app.Service
import android.content.Context
import android.media.AudioFocusRequest
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import androidx.fragment.app.Fragment

abstract class MiwokFragment(val title:CharSequence) : Fragment() {
    abstract val contentList: ArrayList<Word>
    abstract val colorCategory: Int


    private var mediaPlayer: MediaPlayer? = null

    private val audioManager: AudioManager by lazy {
        activity?.getSystemService(Service.AUDIO_SERVICE) as AudioManager
    }

    private val onChangeFocusChangeListener: AudioManager.OnAudioFocusChangeListener =
        AudioManager.OnAudioFocusChangeListener { focusChange ->
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mediaPlayer?.pause()
                mediaPlayer?.seekTo(0)
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mediaPlayer?.start()
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                mediaPlayer?.release()
            }
        }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.miwok_fragment, container, false).apply {
            val listView: ListView = findViewById<ListView>(R.id.list).apply {
                adapter = WordAdapter(rootView.context, contentList, colorCategory)

                onItemClickListener = AdapterView.OnItemClickListener() { adapterView: AdapterView<*>, view1: View, i: Int, l: Long ->

                    val word: Word = adapterView.getItemAtPosition(i) as Word

                    releaseMediaPlayer()

                    val requestFocusResult = if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.O) {
                        audioManager.requestAudioFocus(onChangeFocusChangeListener,
                            AudioManager.STREAM_MUSIC,
                            AudioManager.AUDIOFOCUS_GAIN_TRANSIENT)
                    }else{
                        val focusRequest = AudioFocusRequest.Builder(AudioManager.STREAM_MUSIC).build()
                        audioManager.requestAudioFocus(focusRequest)
                    }
                    if (requestFocusResult == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                        mediaPlayer = MediaPlayer.create(rootView.context, word.audioResourceId)
                        mediaPlayer?.setOnCompletionListener { releaseMediaPlayer() }
                        mediaPlayer?.start()
                    }
                }
            }
        }
    }

    private fun releaseMediaPlayer() {
        mediaPlayer?.release()
        mediaPlayer = null
    }


    override fun onStop() {
        releaseMediaPlayer()
        super.onStop()
        activity
    }

}