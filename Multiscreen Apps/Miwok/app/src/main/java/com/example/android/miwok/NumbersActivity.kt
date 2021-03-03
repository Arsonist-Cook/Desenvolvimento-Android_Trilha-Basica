package com.example.android.miwok

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class NumbersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_numbers)
        var words:ArrayList<Word> = ArrayList<Word>()
        words.add(Word("One", "lutti"))
        words.add(Word("Two", "otiiko"))
        words.add(Word("Three","tolookosu"))
        words.add(Word("Four","oyyisa"))
        words.add(Word("Five","massokka"))
        words.add(Word("Six","temmokka"))
        words.add(Word("Seven","kenekaku"))
        words.add(Word("Eight","kawinta"))
        words.add(Word("Nine","wo’e"))
        words.add(Word("Ten","na’aacha"))

        var listAdapter:WordAdapter = WordAdapter(this, words)
        var listView: ListView = findViewById<ListView>(R.id.list)
        listView.adapter = listAdapter
    }
}