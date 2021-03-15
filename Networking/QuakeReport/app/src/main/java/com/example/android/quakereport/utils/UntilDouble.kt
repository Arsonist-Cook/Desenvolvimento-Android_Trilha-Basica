package com.example.android.quakereport.utils

data class OpenDoubletRange(val from: Double, val to: Double)
infix fun Double.until(to: Double) = OpenDoubletRange(this, to)
operator fun OpenDoubletRange.contains(f: Double) = from <= f && f < to