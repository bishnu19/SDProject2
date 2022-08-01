package edu.msudenver.authentication

import android.content.Context
import android.widget.Toast

fun login(context: Context, email: String, password: String): User {

    val dbHelper = DBHelper(context)
    val db = dbHelper.readableDatabase

    val cursor = db.query(
        "users",
        null,
        "email = \"${email.lowercase()}\"",
        null,
        null,
        null,
        null
    )
    with (cursor) {
        if (!moveToNext())
            throw Error("Authentication failed: email does not exist!")
        val name = getString(1)
        val salt = getString(2)
        val saltedHashPassword = getString(3)
        val saltedHashPasswordToCheck = DBHelper.getHash(password + salt)
        if (!saltedHashPasswordToCheck.equals(saltedHashPassword))
            throw Error("Authentication failed: password does not match!")
        val user = User(email.lowercase(), name)
        return user
    }
}