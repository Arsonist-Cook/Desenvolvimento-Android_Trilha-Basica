package com.example.android.miwok

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlin.reflect.KClass
import kotlin.reflect.KClassifier

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun showNumbers(view: View) {
        val intent: Intent = Intent(this, NumbersActivity::class.java)
        startActivity(intent)
    }

    fun showFamily(view: View) {
        val intent: Intent = Intent(this, FamilyActivity::class.java)
        startActivity(intent)
    }

    fun showColors(view: View) {
        val intent: Intent = Intent(this, ColorsActivity::class.java)
        startActivity(intent)
    }

    fun showPhrases(view: View) {
        val intent: Intent = Intent(this, PhrasesActivity::class.java)
        startActivity(intent)
    }

}