package edu.msudenver.gcpmaps

import android.annotation.SuppressLint
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.util.*

/*
 * CS3013 - Mobile App Dev. - Summer 2022
 * Instructor: Thyago Mota
 * Description: Activity 23 - CreateLocationActivity
 */


class CreateLocationActivity : AppCompatActivity() {

    lateinit var db: SQLiteDatabase
    lateinit var fusedLocationClient: FusedLocationProviderClient
    lateinit var btnAdd: Button
    lateinit var edtDescription: EditText
    lateinit var edtLatitude: EditText
    lateinit var edtLongitude: EditText

    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_location)

        val dbHelper = DBHelper(this)
        db = dbHelper.writableDatabase

        // TODO #10: get references to the view objects
        edtDescription = findViewById(R.id.edtDescription)
        edtLatitude = findViewById(R.id.edtLatitude)
        edtLongitude = findViewById(R.id.edtLongitude)
        btnAdd = findViewById(R.id.btnAdd)

        // TODO #11: finish the implementation of the listener so the location can be added
        btnAdd.setOnClickListener {
            val description = edtDescription.text.toString()
            val visitedDate = DBHelper.ISO_FORMAT.format(Date())
            val latitude = edtLatitude.text.toString().toDouble()
            val longitude = edtLongitude.text.toString().toDouble()
            try {
                db.execSQL(
                    """
                        INSERT INTO locations VALUES
                            ("${description}", "${visitedDate}", ${latitude}, ${longitude})
                    """
                )
                Toast.makeText(
                    this,
                    "New location successfully added!",
                    Toast.LENGTH_SHORT
                ).show()
            } catch (ex: Exception) {
                print(ex.toString())
                Toast.makeText(
                    this,
                    "Exception when trying to add a new location!",
                    Toast.LENGTH_SHORT
                ).show()
            }
            finish()
        }

        // TODO #12: use location services to get the last known location and use it to update the view
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        val task = fusedLocationClient.lastLocation
        task.addOnCompleteListener {
            val location = task.result
            val latitude = (location.latitude * 1000).toInt() / 1000f
            val longitude = (location.longitude * 1000).toInt() / 1000f
            edtLatitude.setText(latitude.toString())
            edtLongitude.setText(longitude.toString())
        }
    }
}

//
//    override fun onLocationChanged(location: Location) {
//        println(location.toString())
//        edtLatitude.setText(location.latitude.toString())
//        edtLongitude.setText(location.longitude.toString())
//        locationManager.removeUpdates(this)
//        btnAdd.isEnabled = true
//    }

//        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
//        locationManager?.requestLocationUpdates(LocationManager.GPS_PROVIDER, )
//        requestLocationUpdates(LocationManager.GPS_PROVIDER, 500, 5f, this)