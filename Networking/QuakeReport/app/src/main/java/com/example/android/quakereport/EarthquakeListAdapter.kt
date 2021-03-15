package com.example.android.quakereport

import android.content.Context
import android.content.Intent
import android.graphics.drawable.GradientDrawable
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.android.quakereport.data.Earthquake
import java.text.SimpleDateFormat

data class OpenDoubletRange(val from: Double, val to: Double)
infix fun Double.until(to: Double) = OpenDoubletRange(this, to)
operator fun OpenDoubletRange.contains(f: Double) = from <= f && f < to

class EarthquakeListAdapter(context: Context, earthquakes: List<Earthquake>) :
    ArrayAdapter<Earthquake>(context, 0, earthquakes) {
    private val dateFormatter: SimpleDateFormat = SimpleDateFormat("LLL dd, yyyy")
    private val timeFormatter:SimpleDateFormat = SimpleDateFormat("h:mm a")

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //Certifica-se que estamos usando um content view não-nulo
        val itemView: View = convertView ?: LayoutInflater.from(context)
                                                    .inflate(R.layout.list_item, parent, false)
        val earthquake:Earthquake? = getItem(position) //Obtém os dados da coleção

        val magnitudeView:TextView = itemView.findViewById<TextView>(R.id.magnitude)
        val locationOffset:TextView  = itemView.findViewById<TextView>(R.id.location_offset)
        val primaryLocation:TextView = itemView.findViewById<TextView>(R.id.primary_location)
        val date:TextView = itemView.findViewById<TextView>(R.id.date)
        val time:TextView = itemView.findViewById<TextView>(R.id.time)

        val circleBackground:GradientDrawable = magnitudeView.background as GradientDrawable
            circleBackground.setColor(getMagnitudeColor(earthquake?.magnitude?: 1.0))

        magnitudeView.text = earthquake?.magnitude.toString()?: "0.0"
        locationOffset.text = earthquake?.location?.substringBeforeLast("of")?:""
        primaryLocation.text = earthquake?.location?.substringAfterLast("of")?:""
        date.text = earthquake?.time?.let { dateFormatter.format(it) }
        time.text = earthquake?.time?.let { timeFormatter.format(it) }

        itemView.setOnClickListener {
            val webpage: Uri = Uri.parse(earthquake?.url)
            val intent: Intent = Intent(Intent.ACTION_VIEW, webpage)
            if (intent.resolveActivity(context.packageManager) != null) {
                context.startActivity(intent)
            }
        }
        return itemView
    }

    private fun getMagnitudeColor(magnitude: Double): Int {
        val magnitudeColorRes :Int = when (magnitude) {
            in 1.0 until 2.0 -> {
                R.color.magnitude1
            }
            in 2.0 until 3.0 -> {
                R.color.magnitude2
            }
            in 3.0 until 4.0 -> {
                R.color.magnitude3
            }
            in 4.0 until 5.0 -> {
                R.color.magnitude4
            }
            in 5.0 until 6.0 -> {
                R.color.magnitude5
            }
            in 6.0 until 7.0 -> {
                R.color.magnitude6
            }
            in 7.0 until 8.0 -> {
                R.color.magnitude7
            }
            in 8.0 until 9.0 -> {
                R.color.magnitude8
            }
            in 9.0 until 10.0 -> {
                R.color.magnitude9
            }
            else -> {
                R.color.magnitude10plus
            }
        }
        return ContextCompat.getColor(context, magnitudeColorRes);
    }

}