package com.example.android.miwok

import android.content.Context
import android.content.res.AssetManager

class NumbersFragment( title:CharSequence) : MiwokFragment(title) {


    override val contentList: ArrayList<Word>
        get() = arrayListOf(
            Word("one", "lutti", R.drawable.number_one, R.raw.number_one),
            Word("two", "otiiko", R.drawable.number_two, R.raw.number_two),
            Word("three", "tolookosu", R.drawable.number_three, R.raw.number_three),
            Word("four", "oyyisa", R.drawable.number_four, R.raw.number_four),
            Word("five", "massokka", R.drawable.number_five, R.raw.number_five),
            Word("six", "temmokka", R.drawable.number_six, R.raw.number_six),
            Word("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven),
            Word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight),
            Word("nine", "wo’e", R.drawable.number_nine, R.raw.number_nine),
            Word("ten", "na’aacha", R.drawable.number_ten, R.raw.number_ten))
    override val colorCategory: Int
        get() = R.color.category_numbers

}