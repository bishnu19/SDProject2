package edu.msudenver.recview

import java.util.*
import kotlin.math.roundToInt

class Activity(var date: Date, distance: Double, time: Double): Comparable<Activity> {

    var time     = if (time < Activity.MINIMUM_VALUE) MINIMUM_VALUE else time
    var distance = if (distance < Activity.MINIMUM_VALUE) MINIMUM_VALUE else distance
    var pace: String = ""
        get() {
            val temp = time / distance
            val minutes = temp.toInt()
            val seconds = ((temp - minutes) * 60).roundToInt()
            return minutes.toString() + ":" + seconds
        }

    companion object {
        val MINIMUM_VALUE = 0.001
    }

    override fun compareTo(other: Activity): Int {
        return date.compareTo(other.date)
    }
}