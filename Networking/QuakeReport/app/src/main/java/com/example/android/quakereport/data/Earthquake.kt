package com.example.android.quakereport.data

data class Earthquake(
    val magnitude: Double,
    val location: String,
    val time: Long,
    val url:String
)