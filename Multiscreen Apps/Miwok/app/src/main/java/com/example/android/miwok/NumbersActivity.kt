package com.example.android.miwok

import android.app.Service
import android.media.AudioFocusRequest
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class NumbersActivity : AppCompatActivity() {
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
        setContentView(R.layout.activity_numbers)

        val words: ArrayList<Word> = ArrayList<Word>()
        words.add(Word("one", "lutti", R.drawable.number_one, R.raw.number_one))
        words.add(Word("two", "otiiko", R.drawable.number_two, R.raw.number_two))
        words.add(Word("three", "tolookosu", R.drawable.number_three, R.raw.number_three))
        words.add(Word("four", "oyyisa", R.drawable.number_four, R.raw.number_four))
        words.add(Word("five", "massokka", R.drawable.number_five, R.raw.number_five))
        words.add(Word("six", "temmokka", R.drawable.number_six, R.raw.number_six))
        words.add(Word("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven))
        words.add(Word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight))
        words.add(Word("nine", "wo’e", R.drawable.number_nine, R.raw.number_nine))
        words.add(Word("ten", "na’aacha", R.drawable.number_ten, R.raw.number_ten))

        val listAdapter: WordAdapter = WordAdapter(this, words, R.color.category_numbers)
        val listView: ListView = findViewById<ListView>(R.id.list)
        listView.adapter = listAdapter
        audioManager = getSystemService(Service.AUDIO_SERVICE) as AudioManager

        listView.onItemClickListener =
            AdapterView.OnItemClickListener() { adapterView: AdapterView<*>, view1: View, i: Int, l: Long ->
                //Toast.makeText(this, "Item Clicked", Toast.LENGTH_SHORT).show()
                val word: Word = adapterView.getItemAtPosition(i) as Word
                //releaseMediaPlayer() //Release resources before playback
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