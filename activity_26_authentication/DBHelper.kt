package edu.msudenver.authentication

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.io.Serializable
import java.security.MessageDigest
import kotlin.random.Random

class DBHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION), Serializable {

    companion object {
        const val DATABASE_NAME = "Authentication.db"
        const val DATABASE_VERSION = 1

        const val SYMBOLS = "abcdefghijklmnopqrstuvwxyz0123456789$%&@!?_-"

        fun getSalt(): String {
            var salt = ""
            while (salt.length < 16)
                salt += SYMBOLS[Random.nextInt(SYMBOLS.length)]
            return salt
        }

        fun getHash(input: String): String {
            return MessageDigest
                .getInstance("SHA256")
                .digest(input.toByteArray()).decodeToString()
        }
    }

    override fun onCreate(db: SQLiteDatabase?) {
        // create the table
        db?.execSQL("""
            CREATE TABLE users ( 
                email       TEXT PRIMARY KEY, 
                name        TEXT NOT NULL, 
                salt        TEXT NOT NULL, 
                password    TEXT NOT NULL )
        """)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // drop the table
        db?.execSQL("""
            DROP TABLE IF EXISTS users
        """)

        // then call "onCreate" again
        onCreate(db)
    }
}