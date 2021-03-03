package com.example.android.miwok

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class PhrasesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phrases)

        val words:ArrayList<Word> = ArrayList<Word>()
        words.add(Word("Where are you going?","minto wuksus"))
        words.add(Word("What is your name?","tinnә oyaase'nә"))
        words.add(Word("My name is...","oyaaset..."))
        words.add(Word("How are you feeling?","michәksәs?"))
        words.add(Word("I’m feeling good.","kuchi achit"))
        words.add(Word("Are you coming?","әәnәs'aa?"))
        words.add(Word("Yes, I’m coming.","hәә’ әәnәm"))
        words.add(Word("I’m coming.","әәnәm"))
        words.add(Word("Let’s go.","yoowutis"))
        words.add(Word("Come here.","әnni'nem"))

        val listAdapter:WordAdapter = WordAdapter(this, words, R.color.category_phrases)
        val listView:ListView = findViewById(R.id.list)
        listView.adapter = listAdapter
    }

}