package com.example.android.miwok

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class ColorsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_colors)

        val words: ArrayList<Word> = ArrayList<Word>()
        words.add(Word("red", "weṭeṭṭi", R.drawable.color_red))
        words.add(Word("green", "chokokki", R.drawable.color_green))
        words.add(Word("brown", "ṭakaakki", R.drawable.color_brown))
        words.add(Word("gray", "ṭopoppi", R.drawable.color_gray))
        words.add(Word("black", "kululli", R.drawable.color_black))
        words.add(Word("white", "kelelli", R.drawable.color_white))
        words.add(Word("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow))
        words.add(Word("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow))

        val listAdapter: WordAdapter = WordAdapter(this, words, R.color.category_colors)
        val listView: ListView = findViewById(R.id.list)
        listView.adapter = listAdapter
    }
}