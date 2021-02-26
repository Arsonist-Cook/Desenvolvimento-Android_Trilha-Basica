package com.example.android.justkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun submitOrder(view:View){
        display(1)
    }

    private fun display(number: Int) {
        val quantityTextView: TextView = findViewById(R.id.order_text_input)
        quantityTextView.text = "$number"
    }
}