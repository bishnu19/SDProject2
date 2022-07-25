package edu.msudenver.gpstrack

import android.location.Location
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions


class MapActivity : AppCompatActivity(), OnMapReadyCallback {

    lateinit var mvMap: MapView
    var locations: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        // TODO #5: extract the locations from the intent

        // TODO #6: get a reference to the Google maps supported fragment
        

        // TODO #7: use getMapAsync to request for a Google maps to be built
    }

    // TODO #8: customize the Google map
    override fun onMapReady(gm: GoogleMap) {
        
    }
}