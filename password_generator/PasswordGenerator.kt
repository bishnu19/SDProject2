package edu.msudenver.passwordgenerator

import java.io.Serializable
import kotlin.random.Random

class PasswordGenerator(
    private var length: Int,
    special: Boolean,
    numbers: Boolean,
    lowercase: Boolean,
    uppercase: Boolean): Serializable {

    private var charOptions = ""
    var password: String? = null

    init {
        length = if (length < 1) 1 else length
        charOptions += if (special)   SPECIAL   else ""
        charOptions += if (numbers)   NUMBERS   else ""
        charOptions += if (lowercase) LOWERCASE else ""
        charOptions += if (uppercase) UPPERCASE else ""
    }

    companion object {
        const val SPECIAL = "#$%!_-";
        const val NUMBERS = "0123456789"
        const val LOWERCASE = "abcdefghijklmnopqrstuvwxyz"
        const val UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    }

    fun generate() {
        password = ""
        for (i in 0 until length)
            password += charOptions[Random.nextInt(charOptions.length)]
    }
}