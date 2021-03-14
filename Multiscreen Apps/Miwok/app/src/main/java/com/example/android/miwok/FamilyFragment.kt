package com.example.android.miwok

class FamilyFragment (title:CharSequence)  : MiwokFragment(title) {
    override val contentList: ArrayList<Word>
        get() = arrayListOf(Word("father", "әpә", R.drawable.family_father, R.raw.family_father),
            Word("mother", "әṭa", R.drawable.family_mother, R.raw.family_mother),
            Word("son", "angsi", R.drawable.family_son, R.raw.family_son),
            Word("daughter", "tune", R.drawable.family_daughter, R.raw.family_daughter),
            Word("older brother",
                "taachi",
                R.drawable.family_older_brother,
                R.raw.family_older_brother),
            Word("younger brother",
                "chalitti",
                R.drawable.family_younger_brother,
                R.raw.family_younger_brother),
            Word("older sister",
                "teṭe",
                R.drawable.family_older_sister,
                R.raw.family_older_sister),
            Word("younger sister",
                "kolliti",
                R.drawable.family_younger_sister,
                R.raw.family_younger_sister),
            Word("grandmother",
                "ama",
                R.drawable.family_grandmother,
                R.raw.family_grandmother),
            Word("grandfather",
                "paapa",
                R.drawable.family_grandfather,
                R.raw.family_grandfather))
    override val colorCategory: Int
        get() = R.color.category_family
}