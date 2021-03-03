package com.example.android.miwok

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import java.util.*
import kotlin.collections.ArrayList

class WordAdapter(context: Context, words: ArrayList<Word>, catColor: Int) :
    ArrayAdapter<Word>(context, 0, words) {
    private val categoryColor: Int = catColor

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Check if the existing view is being reused, otherwise inflate the view
        val listItemView: View =
            convertView ?: LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)

        val word: Word? = getItem(position)

        val imageView: ImageView? = listItemView.findViewById(R.id.image)

        if (word?.hasImage() == true) {
            imageView?.setImageResource(word?.imageResourceId)
        } else {
            imageView?.visibility = View.GONE
        }

        val itemContent: LinearLayout? = listItemView.findViewById(R.id.item_content)
        itemContent?.setBackgroundColor(ContextCompat.getColor(context, categoryColor))

        val defaultTextView: TextView? = listItemView.findViewById(R.id.default_text_view)
        defaultTextView?.text = word?.defaultTranslation

        val miwokTextView: TextView? = listItemView.findViewById(R.id.miwok_text_view)
        miwokTextView?.text = word?.miwokTranslation

        return listItemView
    }
}