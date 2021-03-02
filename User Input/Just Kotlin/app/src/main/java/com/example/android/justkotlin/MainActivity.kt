package com.example.android.justkotlin

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Path
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.example.android.justkotlin.utils.Order

val mailToAddresses = arrayOf("sendmailTo@app.com")

class MainActivity : AppCompatActivity() {

    private var order: Order = Order(this)
    private var summaryTextView: TextView? = null
    private var quantityTextView: TextView? = null
    private var editText: EditText? = null
    private var submitBtn: Button? = null
    private var summaryLabel:TextView? = null
    private var state: OperationState = OperationState.ORDER

    enum class OperationState { SUBMIT, ORDER }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startupVariables()
        displayQuantity()
    }

    private fun startupVariables() {
        summaryTextView = findViewById(R.id.summary_text_view)
        quantityTextView = findViewById(R.id.order_text_input)
        editText = findViewById(R.id.name_edit_text)
        submitBtn = findViewById(R.id.order_btn)
        summaryLabel = findViewById(R.id.summary_label)

        //hookup Event Listener
        editText?.doAfterTextChanged { text: Editable? ->
            order.nameOrder = text.toString()
            cleanSummary()
        }
    }

    fun submitOrder(view: View) {
        when (state) {
            (OperationState.SUBMIT) -> {
                //@TODO implements submit mail to


                val sendMailTo: Intent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:")
                    putExtra(Intent.EXTRA_EMAIL, mailToAddresses)
                    putExtra(
                        Intent.EXTRA_SUBJECT,
                        "${getString(R.string.app_name)} ${
                            getString(
                                R.string.order_to,
                                order.nameOrder
                            )
                        }"
                    )
                    putExtra(Intent.EXTRA_TEXT, order.getSummaryOrder())
                }

                sendMailTo.resolveActivity(packageManager) ?: startActivity(sendMailTo)
            }

            (OperationState.ORDER) -> {
                displaySummary()
                submitBtn?.text = getString(R.string.submit)
                state = OperationState.SUBMIT
            }
            else -> {
                Toast.makeText(this, getString(R.string.something_whent_wrong), Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun displayQuantity() {
        (this.quantityTextView)?.text = "${order.cupsOfCoffee}"
        cleanSummary()
    }

    private fun displaySummary() {
        (this.summaryTextView)?.text = order.getSummaryOrder()
        (this.summaryLabel)?.visibility = View.VISIBLE
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
        cleanSummary()
    }

    fun setChocolateTopping(view: View) {
        (view as CheckBox).isChecked.also { order.hasChocolateTopping = it }
        cleanSummary()
    }

    private fun cleanSummary() {
        if (state == OperationState.SUBMIT) {
            (this.summaryTextView)?.visibility = View.GONE
            (this.summaryLabel)?.visibility = View.INVISIBLE
            (this.submitBtn)?.text = getString(R.string.order)
            state = OperationState.ORDER
        }
    }
}