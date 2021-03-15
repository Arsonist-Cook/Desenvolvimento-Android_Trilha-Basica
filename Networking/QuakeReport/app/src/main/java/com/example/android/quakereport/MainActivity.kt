package com.example.android.quakereport

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.example.android.quakereport.utils.QueryUtils
import com.example.android.quakereport.utils.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listView = findViewById<ListView>(R.id.list)
        listView.adapter = EarthquakeListAdapter(this, QueryUtils(Response.JSON_STRING).featuresObject)
    }
}