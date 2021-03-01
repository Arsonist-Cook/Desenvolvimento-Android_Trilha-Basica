package com.example.android.justkotlin

import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import com.example.android.justkotlin.utils.Order


class MainActivity : AppCompatActivity() {

    var order: Order = Order()
    var summaryTextView:TextView? = null
    var quantityTextView:TextView? = null
    var editText:EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startupVariables()
        displayQuantity()
    }

    private fun startupVariables(){
        summaryTextView = findViewById(R.id.summary_text_view)
        quantityTextView = findViewById(R.id.order_text_input)
        editText = findViewById(R.id.name_edit_text)

        //hookup Event Listener
        editText?.doAfterTextChanged { text:Editable? -> order.nameOrder = text.toString() }
    }

    fun submitOrder(view: View) {
        displaySummary()
    }

    private fun displayQuantity() {
        (this.quantityTextView)?.text  = "${order.cupsOfCoffee}"
    }

    private fun displaySummary() {
        (this.summaryTextView)?.text = order.getSummaryOrder()
        (this.summaryTextView)?.visibility = View.VISIBLE
    }

    fun incrementCup(view: View) {
        this.order.addCoffee()
        displayQuantity()
    }

    fun decrementCup(view: View) {
        this.order.subtractCoffee()
        displayQuantity()
    }

    fun setWhippedCreamTopping(view: View) {
        (view as CheckBox).isChecked.also { order.hasWhippedCream = it }
    }

    fun setChocolateTopping(view: View) {
        (view as CheckBox).isChecked.also { order.hasChocolateTopping = it }
    }
}