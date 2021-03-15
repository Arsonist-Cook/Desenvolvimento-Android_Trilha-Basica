package com.example.android.quakereport.utils

import com.example.android.quakereport.data.Earthquake
import org.json.JSONArray
import org.json.JSONObject

class QueryUtils(jsonStr: String) {
    private val features: JSONArray = JSONObject(jsonStr).getJSONArray("features")
    val featuresObject: MutableList<Earthquake> = mutableListOf<Earthquake>().apply {
        for (index in 0 until features.length()) {
            var properties = features.getJSONObject(index).getJSONObject("properties")
            add(
                Earthquake(
                    properties.getDouble("mag"),
                    properties.getString("place"),
                    properties.getLong("time"),
                    properties.getString("url")
                )
            )
        }
    }

}