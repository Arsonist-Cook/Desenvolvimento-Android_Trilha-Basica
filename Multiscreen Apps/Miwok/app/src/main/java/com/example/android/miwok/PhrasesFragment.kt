package com.example.android.miwok

class PhrasesFragment(title:CharSequence) : MiwokFragment(title) {
    override val contentList: ArrayList<Word>
        get() = arrayListOf(
            Word("Where are you going?",
                "minto wuksus",
                Word.NO_IMAGE_PROVIDE,
                R.raw.phrase_where_are_you_going),
            Word("What is your name?",
                "tinnә oyaase'nә",
                Word.NO_IMAGE_PROVIDE,
                R.raw.phrase_what_is_your_name),
            Word("My name is...",
                "oyaaset...",
                Word.NO_IMAGE_PROVIDE,
                R.raw.phrase_my_name_is),
            Word("How are you feeling?",
                "michәksәs?",
                Word.NO_IMAGE_PROVIDE,
                R.raw.phrase_how_are_you_feeling),
            Word("I’m feeling good.",
                "kuchi achit",
                Word.NO_IMAGE_PROVIDE,
                R.raw.phrase_im_feeling_good),
            Word("Are you coming?",
                "әәnәs'aa?",
                Word.NO_IMAGE_PROVIDE,
                R.raw.phrase_are_you_coming),
            Word("Yes, I’m coming.",
                "hәә’ әәnәm",
                Word.NO_IMAGE_PROVIDE,
                R.raw.phrase_yes_im_coming),
            Word("I’m coming.",
                "әәnәm",
                Word.NO_IMAGE_PROVIDE,
                R.raw.phrase_im_coming),
            Word("Let’s go.",
                "yoowutis",
                Word.NO_IMAGE_PROVIDE,
                R.raw.phrase_lets_go),
            Word("Come here.",
                "әnni'nem",
                Word.NO_IMAGE_PROVIDE,
                R.raw.phrase_come_here))

    override val colorCategory: Int
        get() = R.color.category_phrases

}