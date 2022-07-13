package edu.msudenver.crud

import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import java.lang.Exception

class CreateUpdateActivity: AppCompatActivity(), View.OnClickListener {

    var op = CREATE_OP
    var category = 0
    lateinit var db: SQLiteDatabase
    lateinit var edtName: EditText
    lateinit var edtQuantity: EditText
    lateinit var edtUnit: EditText

    companion object {
        const val CREATE_OP = 0
        const val UPDATE_OP = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_update)

        // TODO #1: get references to the view objects
        edtName = findViewById(R.id.edtName)
        val spnCategory: Spinner = findViewById(R.id.spnCategory)
        edtQuantity = findViewById(R.id.edtQuantity)
        edtUnit = findViewById(R.id.edtUnit)

        // TODO #2: define the spinner's adapter as an ArrayAdapter of String
        spnCategory.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Item.CATEGORY_DESCRIPTIONS)

        // TODO #3: get a reference to the "CREATE/UPDATE" button and sets its listener
        val btnCreateUpdate: Button = findViewById(R.id.btnCreateUpdate)
        btnCreateUpdate.setOnClickListener(this)

        // TODO #4: get a "writable" db connection
        val dbHelper = DBHelper(this)
        db = dbHelper.writableDatabase

        // TODO #5: gets the operation and updates the view accordingly
        op = intent.getIntExtra("op", CREATE_OP)
        if (op == CREATE_OP)
            btnCreateUpdate.text = "CREATE"
    }

    // TODO #6: insert a new shopping list item into the database
    // show a toast message saying whether the db operation was successful or not
    // call finish to resume back to the MainActivity
    override fun onClick(view: View?) {
        val name = findViewById<EditText>(R.id.edtName).text.toString()
        val quantity = findViewById<EditText>(R.id.edtQuantity).text.toString().toInt()
        val unit = findViewById<EditText>(R.id.edtUnit).text.toString()
        if (op == CREATE_OP) {
            try {
                db.execSQL(
                    """
                        INSERT INTO items VALUES
                            ("${name}", ${category}, ${quantity}, "${unit}")
                    """
                )
                Toast.makeText(
                    this,
                    "New shopping list item successfully created!",
                    Toast.LENGTH_SHORT
                ).show()
            } catch (ex: Exception) {
                print(ex.toString())
                Toast.makeText(
                    this,
                    "Exception when trying to create a new shopping list!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        finish()
    }
}