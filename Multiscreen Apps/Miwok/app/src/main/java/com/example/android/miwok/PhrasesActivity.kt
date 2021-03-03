package com.example.android.miwok

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView

class PhrasesActivity : AppCompatActivity() {
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phrases)

        val words: ArrayList<Word> = ArrayList<Word>()
        words.add(Word("Where are you going?",
            "minto wuksus",
            Word.NO_IMAGE_PROVIDE,
            R.raw.phrase_where_are_you_going))
        words.add(Word("What is your name?",
            "tinnә oyaase'nә",
            Word.NO_IMAGE_PROVIDE,
            R.raw.phrase_what_is_your_name))
        words.add(Word("My name is...",
            "oyaaset...",
            Word.NO_IMAGE_PROVIDE,
            R.raw.phrase_my_name_is))
        words.add(Word("How are you feeling?",
            "michәksәs?",
            Word.NO_IMAGE_PROVIDE,
            R.raw.phrase_how_are_you_feeling))
        words.add(Word("I’m feeling good.",
            "kuchi achit",
            Word.NO_IMAGE_PROVIDE,
            R.raw.phrase_im_feeling_good))
        words.add(Word("Are you coming?",
            "әәnәs'aa?",
            Word.NO_IMAGE_PROVIDE,
            R.raw.phrase_are_you_coming))
        words.add(Word("Yes, I’m coming.",
            "hәә’ әәnәm",
            Word.NO_IMAGE_PROVIDE,
            R.raw.phrase_yes_im_coming))
        words.add(Word("I’m coming.",
            "әәnәm",
            Word.NO_IMAGE_PROVIDE,
            R.raw.phrase_im_coming))
        words.add(Word("Let’s go.",
            "yoowutis",
            Word.NO_IMAGE_PROVIDE,
            R.raw.phrase_lets_go))
        words.add(Word("Come here.",
            "әnni'nem",
            Word.NO_IMAGE_PROVIDE,
            R.raw.phrase_come_here))

        val listAdapter: WordAdapter = WordAdapter(this, words, R.color.category_phrases)
        val listView: ListView = findViewById(R.id.list)
        listView.adapter = listAdapter

        listView.onItemClickListener =
            AdapterView.OnItemClickListener() { adapterView: AdapterView<*>, view1: View, i: Int, l: Long ->
                //Toast.makeText(this, "Item Clicked", Toast.LENGTH_SHORT).show()
                val word: Word = adapterView.getItemAtPosition(i) as Word
                mediaPlayer = MediaPlayer.create(this, word.audioResourceId)
                mediaPlayer.start()
            }
    }

}