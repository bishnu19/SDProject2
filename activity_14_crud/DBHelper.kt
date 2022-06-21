package edu.msudenver.crud

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        const val DATABASE_NAME = "ShoppingList.db"
        const val DATABASE_VERSION = 2
    }

    override fun onCreate(db: SQLiteDatabase?) {
        // create the table
        db?.execSQL("""
            CREATE TABLE items ( 
                name        TEXT PRIMARY KEY, 
                category    INTEGER NOT NULL, 
                quantity    INTEGER NOT NULL, 
                unit        TEXT )
        """)

        // populate the table with a few items
        db?.execSQL("""
            INSERT INTO items VALUES 
                ("eggs", ${Item.DAIRY_AND_EGGS}, 1, "dozen"),
                ("milk", ${Item.DAIRY_AND_EGGS}, 2, "gallon"), 
                ("bread", ${Item.BREAD_AND_GRAINS}, 1, "bag"),
                ("strawberry", ${Item.FRUITS}, 1, "box"),
                ("sugar", ${Item.BAKING_AND_SPICES}, 4, "pound"), 
                ("carrots", ${Item.VEGETABLES}, 1, "pound"),
                ("onions", ${Item.VEGETABLES}, 2, "pound"), 
                ("coors", ${Item.BEVERAGES}, 1, "6-pack")
        """)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // drop the table
        db?.execSQL("""
            DROP TABLE IF EXISTS items
        """)

        // then call "onCreate" again
        onCreate(db)
    }
}