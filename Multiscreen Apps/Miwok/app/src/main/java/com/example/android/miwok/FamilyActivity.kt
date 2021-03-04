package com.example.android.miwok

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView

class FamilyActivity : AppCompatActivity() {
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_family)

        val words: ArrayList<Word> = ArrayList<Word>()
        words.add(Word("father", "әpә", R.drawable.family_father, R.raw.family_father))
        words.add(Word("mother", "әṭa", R.drawable.family_mother, R.raw.family_mother))
        words.add(Word("son", "angsi", R.drawable.family_son, R.raw.family_son))
        words.add(Word("daughter", "tune", R.drawable.family_daughter, R.raw.family_daughter))
        words.add(Word("older brother",
            "taachi",
            R.drawable.family_older_brother,
            R.raw.family_older_brother))
        words.add(Word("younger brother",
            "chalitti",
            R.drawable.family_younger_brother,
            R.raw.family_younger_brother))
        words.add(Word("older sister",
            "teṭe",
            R.drawable.family_older_sister,
            R.raw.family_older_sister))
        words.add(Word("younger sister",
            "kolliti",
            R.drawable.family_younger_sister,
            R.raw.family_younger_sister))
        words.add(Word("grandmother",
            "ama",
            R.drawable.family_grandmother,
            R.raw.family_grandmother))
        words.add(Word("grandfather",
            "paapa",
            R.drawable.family_grandfather,
            R.raw.family_grandfather))

        val listAdapter: WordAdapter = WordAdapter(this, words, R.color.category_family)
        val listView: ListView = findViewById(R.id.list)
        listView.adapter = listAdapter

        listView.onItemClickListener =
            AdapterView.OnItemClickListener() { adapterView: AdapterView<*>, view1: View, i: Int, l: Long ->
                //Toast.makeText(this, "Item Clicked", Toast.LENGTH_SHORT).show()
                val word: Word = adapterView.getItemAtPosition(i) as Word
                releaseMediaPlayer()
                mediaPlayer = MediaPlayer.create(this, word.audioResourceId)
                mediaPlayer?.start()
                mediaPlayer?.setOnCompletionListener { releaseMediaPlayer() }
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