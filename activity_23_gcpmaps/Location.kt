package edu.msudenver.gcpmaps

import java.util.*

/*
 * CS3013 - Mobile App Dev. - Summer 2022
 * Instructor: Thyago Mota
 * Description: Activity 23 - Location
 */

data class Location(
    var id: Int,
    var description: String,
    var visitedDate: Date,
    var latitude: Double,
    var longitude: Double)