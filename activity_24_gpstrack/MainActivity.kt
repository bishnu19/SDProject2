package edu.msudenver.gpstrack

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity(), LocationListener {

    lateinit var txtLocations: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtLocations = findViewById(R.id.txtLocations)

        // TODO #1: use getSystemService to get a reference to the location manager
        

        // TODO #2: ask the location manager for location updates from the GPS provider every 15s and if the (current) location changed at least 100 feet.
        

        val btnDone: Button = findViewById(R.id.btnDone)
        // TODO #3: when the "DONE" button is tapped, the locations in txtLocations should be passed to MapActivity through an intent (use "locations" as the key)
        btnDone.setOnClickListener {
            
        }
    }

    // TODO #4: update the txtLocations with the new GPS location
    override fun onLocationChanged(location: Location) {
        
    }
}