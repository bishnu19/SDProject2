package edu.msudenver.gcpmaps

/*
 * CS3013 - Mobile App Dev. - Summer 2022
 * Instructor: Thyago Mota
 * Description: Activity 23 - DisplayLocationActivity
 */

import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.squareup.picasso.Picasso

class DisplayLocationActivity : AppCompatActivity() {

    var imgMap: ImageView? = null
    lateinit var db: SQLiteDatabase

    companion object {
        const val BASE_URL = "https://maps.googleapis.com/maps/api/staticmap"
        const val ZOOM = 13
        const val SIZE = "320x480"
    }

    // TODO #8: implement the function
    fun retrieveLocation(id: Int): Location {
        val cursor = db.query(
            "locations",
            arrayOf<String>("rowid, description, visited_date, latitude, longitude"),
            "rowid = ${id}",
            null,
            null,
            null,
            null
        )
        with (cursor) {
            cursor.moveToNext()
            val id = getInt(0)
            val description = getString(1)
            val visitedDate = DBHelper.ISO_FORMAT.parse(getString(2))
            val latitude = getDouble(3)
            val longitude = getDouble(4)
            val location = Location(id, description, visitedDate, latitude, longitude)
            return location
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_location)

        val dbHelper = DBHelper(this)
        db = dbHelper.readableDatabase
        val id = intent.getIntExtra("id", 0)
        val location = retrieveLocation(id)

        // TODO #9: update the image view with the result of google maps
        val key = getString(R.string.GCP_MAPS_KEY)
        val markers = "${location.latitude},${location.longitude}"
        val urlString = BASE_URL + "?key=${key}&zoom=${ZOOM}&size=${SIZE}&markers=${markers}"
        imgMap = findViewById(R.id.imgMap)
        Picasso.with(this).load(urlString).into(imgMap)
    }
}