package edu.msudenver.crud

import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.lang.Exception

class CreateActivity : AppCompatActivity() {

    var category = 0
    lateinit var db: SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        // TODO #1: get a reference to the spinner object
        val spnCategory: Spinner = findViewById()

        // TODO #2: define the spinner's adapter as an ArrayAdapter of String
        // hint: use the predefined "android.R.layout.simple_spinner_item" for the layout of each individual item in the spinner
        // hint: use Item.CATEGORY_DESCRIPTIONS to populate the ArrayAdapter
        spnCategory.adapter = ArrayAdapter<String>(this, , )

        // TODO #3: set the "onItemSelectedListener" for the spinner, saving the category (id) of the item when the spinner changes
        spnCategory.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                category = 
            }
        }

        // TODO #4: get a "writable" db connection
        val dbHelper = DBHelper(this)
        db = dbHelper.

        // TODO #5: get a reference to the "CREATE" button
        val btnCreate: Button = findViewById()

        // TODO #6: set its listener to collect all values from the view; then insert a new shopping list item into the database
        // show a toast message saying whether the db operation was successful or not
        // call finish to resume back to the MainActivity
        btnCreate.setOnClickListener {
            

            try {
                db.execSQL("""
                    INSERT INTO items VALUES 
                        ()
                """)
                Toast.makeText(this, , Toast.LENGTH_SHORT).show()
            }
            catch (ex: Exception) {
                print(ex.toString())
                Toast.makeText(this, , Toast.LENGTH_SHORT).show()
            }
            
        }
    }
}

