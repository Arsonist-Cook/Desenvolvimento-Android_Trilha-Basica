package com.example.android.miwok

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class WordAdapter(context: Context, words: ArrayList<Word>) :
    ArrayAdapter<Word>(context, 0, words) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Check if the existing view is being reused, otherwise inflate the view
        val listItemView: View =
            convertView ?: LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)

        // Get the {@link Word} object located at this position in the list
        val word: Word? = getItem(position)
        val defaultTextView: TextView? = listItemView.findViewById(R.id.default_text_view)
        defaultTextView?.text = word?.defaultTranslation

        val miwokTextView: TextView? = listItemView.findViewById(R.id.miwok_text_view)
        miwokTextView?.text = word?.miwokTranslation

        return listItemView
    }
}