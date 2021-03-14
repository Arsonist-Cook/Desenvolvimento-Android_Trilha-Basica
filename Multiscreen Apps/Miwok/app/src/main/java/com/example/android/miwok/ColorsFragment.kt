package com.example.android.miwok

class ColorsFragment (title:CharSequence) : MiwokFragment(title) {
    override val contentList: ArrayList<Word>
        get() = arrayListOf(Word("red", "weṭeṭṭi", R.drawable.color_red, R.raw.color_red),
            Word("green", "chokokki", R.drawable.color_green, R.raw.color_green),
            Word("brown", "ṭakaakki", R.drawable.color_brown, R.raw.color_brown),
            Word("gray", "ṭopoppi", R.drawable.color_gray, R.raw.color_gray),
            Word("black", "kululli", R.drawable.color_black, R.raw.color_black),
            Word("white", "kelelli", R.drawable.color_white, R.raw.color_white),
            Word("dusty yellow",
                "ṭopiisә",
                R.drawable.color_dusty_yellow,
                R.raw.color_dusty_yellow),
            Word("mustard yellow",
                "chiwiiṭә",
                R.drawable.color_mustard_yellow,
                R.raw.color_mustard_yellow))
    override val colorCategory: Int
        get() = R.color.category_colors
}