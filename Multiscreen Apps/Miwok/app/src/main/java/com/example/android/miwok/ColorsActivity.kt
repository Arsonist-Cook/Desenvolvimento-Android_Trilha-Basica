package com.example.android.miwok

import android.app.Service
import android.media.AudioFocusRequest
import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

class ColorsActivity : AppCompatActivity() {
    private var mediaPlayer: MediaPlayer? = null
    private lateinit var audioManager: AudioManager
    private val onChangeFocusChangeListener: AudioManager.OnAudioFocusChangeListener =
        AudioManager.OnAudioFocusChangeListener { focusChange ->
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mediaPlayer?.pause()
                mediaPlayer?.seekTo(0)
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mediaPlayer?.start()
            }else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                mediaPlayer?.release()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_colors)

        val words: ArrayList<Word> = ArrayList<Word>()
        words.add(Word("red", "weṭeṭṭi", R.drawable.color_red, R.raw.color_red))
        words.add(Word("green", "chokokki", R.drawable.color_green, R.raw.color_green))
        words.add(Word("brown", "ṭakaakki", R.drawable.color_brown, R.raw.color_brown))
        words.add(Word("gray", "ṭopoppi", R.drawable.color_gray, R.raw.color_gray))
        words.add(Word("black", "kululli", R.drawable.color_black, R.raw.color_black))
        words.add(Word("white", "kelelli", R.drawable.color_white, R.raw.color_white))
        words.add(Word("dusty yellow",
            "ṭopiisә",
            R.drawable.color_dusty_yellow,
            R.raw.color_dusty_yellow))
        words.add(Word("mustard yellow",
            "chiwiiṭә",
            R.drawable.color_mustard_yellow,
            R.raw.color_mustard_yellow))

        val listAdapter: WordAdapter = WordAdapter(this, words, R.color.category_colors)
        val listView: ListView = findViewById(R.id.list)
        listView.adapter = listAdapter
        audioManager = getSystemService(Service.AUDIO_SERVICE) as AudioManager
        listView.onItemClickListener =
            AdapterView.OnItemClickListener() { adapterView: AdapterView<*>, view1: View, i: Int, l: Long ->
                //Toast.makeText(this, "Item Clicked", Toast.LENGTH_SHORT).show()
                val word: Word = adapterView.getItemAtPosition(i) as Word
                releaseMediaPlayer()
                mediaPlayer = MediaPlayer.create(this, word.audioResourceId)
                mediaPlayer?.setOnCompletionListener { releaseMediaPlayer() }
                val requestFocusResult = if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.O) {
                    audioManager.requestAudioFocus(onChangeFocusChangeListener,
                        AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT)
                }else{
                    val focusRequest = AudioFocusRequest.Builder(AudioManager.STREAM_MUSIC).build()
                    audioManager.requestAudioFocus(focusRequest)
                }
                if (requestFocusResult == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mediaPlayer?.start()
                }

            }
    }

    private fun releaseMediaPlayer() {
        mediaPlayer?.release()
        mediaPlayer = null
    }

    override fun onStop() {
        super.onStop()
        releaseMediaPlayer()
    }
}