package com.example.android.justkotlin.utils

import android.content.Context
import com.example.android.justkotlin.R
import java.text.NumberFormat

const val COFFEE_BASE_PRICE: Double = 5.0
const val WHIPPED_CREAM_ADD_PRICE: Double = 1.0
const val CHOCOLATE_TOPPING_PRICE: Double = 2.0

class Order(private val context: Context) {
    var cupsOfCoffee: Int = 0
        private set
    var hasWhippedCream: Boolean = false
    var hasChocolateTopping: Boolean = false
    var nameOrder: String = ""

    /**
     * @return String: Total Price already Calculated
     */
    private fun calculateTotalPrice(): String {
        var actualPrice: Double = COFFEE_BASE_PRICE
        if (hasWhippedCream) {
            actualPrice += WHIPPED_CREAM_ADD_PRICE
        }
        if (hasChocolateTopping) {
            actualPrice += CHOCOLATE_TOPPING_PRICE
        }
        actualPrice *= cupsOfCoffee
        return NumberFormat.getCurrencyInstance().format(actualPrice)
    }

    fun addCoffee() {
        cupsOfCoffee++
    }

    fun subtractCoffee() {
        if (cupsOfCoffee > 0) {
            cupsOfCoffee--
        }
    }

    fun getSummaryOrder(): String {
        return "${context.getString(R.string.summary_name, nameOrder)}\n" +
                "${context.getString(R.string.topping_title_summary)}\n" +
                " - ${context.getString(R.string.whipped_cream_summary,hasWhippedCream)}\n" +
                " - ${context.getString(R.string.chocolate_topping_summary,hasChocolateTopping)}\n" +
                "${context.getString(R.string.quantity_summary, cupsOfCoffee)}\n" +
                "${context.getString(R.string.total_cost_summary, calculateTotalPrice())}\n" +
                context.getString(R.string.greetings_summary)
    }
}