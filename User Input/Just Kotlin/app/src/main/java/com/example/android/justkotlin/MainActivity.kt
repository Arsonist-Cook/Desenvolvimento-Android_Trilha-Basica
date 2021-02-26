package com.example.android.justkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    var numberOfCoffees: Int = 0
    var priceOfCoffee: Double = 5.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        display(numberOfCoffees)
        displayPrice(numberOfCoffees * priceOfCoffee)
    }

    fun submitOrder(view: View) {
        display(numberOfCoffees)
        displayPrice(numberOfCoffees * priceOfCoffee)
    }

    private fun display(number: Int) {
        val quantityTextView: TextView = findViewById(R.id.order_text_input)
        quantityTextView.text = "$number"
    }

    private fun displayPrice(number: Double) {
        val priceTextView: TextView = findViewById(R.id.price_text_input)
        priceTextView.text = NumberFormat.getCurrencyInstance().format(number)
    }

    fun incrementCup(view: View) {
        numberOfCoffees++
        display(numberOfCoffees)
    }

    fun decrementCup(view: View) {
        if (numberOfCoffees > 0) {
            numberOfCoffees--
            display(numberOfCoffees)
        }
    }

}