package edu.msudenver.fruits

/*
 * CS3013 - Mobile App Dev. - Summer 2022
 * Instructor: Thyago Mota
 * Description: Homework 07 - MainActivity
 */

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.coroutines.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    val fruits = arrayOf("Apple", "Banana", "Blueberry", "Orange", "Strawberry", "Raspberry", "Peach", "Watermelon", "Melon")
    var txtFruit: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtFruit = findViewById(R.id.txtFruit)

        // TODO: start a coroutine in GlobalScope and with context Dispatchers.Main to updated txtFruit with a random fruit from fruits at every second
        
        
    }
}