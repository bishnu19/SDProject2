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
        

        // TODO #11: finish the implementation of the listener so the location can be added
        btnAdd.setOnClickListener {
            
        }

        // TODO #12: use location services to get the last known location and use it to update the view
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        val task = fusedLocationClient.lastLocation
        task.addOnCompleteListener {
            
        }
    }
}
