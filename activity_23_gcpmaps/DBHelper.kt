package edu.msudenver.gcpmaps

/*
 * CS3013 - Mobile App Dev. - Summer 2022
 * Instructor: Thyago Mota
 * Description: Activity 23 - DBHelper
 */

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.io.Serializable
import java.text.SimpleDateFormat

class DBHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION), Serializable {

    companion object {
        const val DATABASE_NAME = "Locations.db"
        const val DATABASE_VERSION = 1
        val ISO_FORMAT = SimpleDateFormat("yyyy-MM-dd")
        val USA_FORMAT = SimpleDateFormat("MM/dd/yyyy")
    }

    override fun onCreate(db: SQLiteDatabase?) {
        // create the table
        db?.execSQL("""
            CREATE TABLE locations ( 
                description  TEXT NOT NULL, 
                visited_date TEXT NOT NULL, 
                latitude     DOUBLE NOT NULL, 
                longitude    DOUBLE NOT NULL )
        """)

        // populate the table with a few items
        db?.execSQL("""
            INSERT INTO locations VALUES 
                ("MSU Denver", "2022-07-18", 39.7450, -105.0087)
        """)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // drop the table
        db?.execSQL("""
            DROP TABLE IF EXISTS locations
        """)

        // then call "onCreate" again
        onCreate(db)
    }
}