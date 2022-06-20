package edu.msudenver.dice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import java.io.Serializable
import kotlin.random.Random

// model class for this app!
class Dice(sides: Int = DEFAULT_NUMBER_SIDES): Serializable {

    var sides = if (sides < MIN_NUMBER_SIDES) MIN_NUMBER_SIDES else sides
        set(value) {
            if (value >= MIN_NUMBER_SIDES) {
                field = value
                this.value = INITIAL_VALUE
            }
        }
    var value = INITIAL_VALUE

    companion object {
        const val MIN_NUMBER_SIDES     = 2
        const val DEFAULT_NUMBER_SIDES = 6
        const val INITIAL_VALUE        = 1
    }

    fun roll() {
        value = Random.nextInt(1, sides + 1)
    }
}

class MainActivity : AppCompatActivity() {

    var dice = Dice()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtDice: TextView = findViewById(R.id.txtDice)
        txtDice.setOnClickListener {
            dice.roll()
            txtDice.text = dice.value.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable("dice", dice)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        dice = savedInstanceState.getSerializable("dice") as Dice
        val txtDice: TextView = findViewById(R.id.txtDice)
        txtDice.text = dice.value.toString()
    }
}