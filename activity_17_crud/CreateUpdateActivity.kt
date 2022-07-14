package edu.msudenver.shoppinglist

import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import java.lang.Exception

class CreateUpdateActivity: AppCompatActivity(), View.OnClickListener {

    var op = CREATE_OP
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

        // gets references to the view objects
        edtName = findViewById(R.id.edtName)
        val spnCategory: Spinner = findViewById(R.id.spnCategory)
        edtQuantity = findViewById(R.id.edtQuantity)
        edtUnit = findViewById(R.id.edtUnit)

        // defines the spinner's adapter as an ArrayAdapter of String
        spnCategory.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Item.CATEGORY_DESCRIPTIONS)

        // gets a reference to the "CREATE/UPDATE" button and sets its listener
        val btnCreateUpdate: Button = findViewById(R.id.btnCreateUpdate)
        btnCreateUpdate.setOnClickListener(this)

        // gets a "writable" db connection
        val dbHelper = DBHelper(this)
        db = dbHelper.writableDatabase

        // gets the operation and updates the view accordingly
        op = intent.getIntExtra("op", CREATE_OP)
        if (op == CREATE_OP)
            btnCreateUpdate.text = "CREATE"
        // TODO #5: write the code for the "update" operation
        else {
            btnCreateUpdate.text = "UPDATE"
            val name = intent.getStringExtra("name") ?: ""
            edtName.setText(name)
            edtName.isEnabled = false
            val item = retrieveItem(name)
            spnCategory.setSelection(item.category)
            edtQuantity.setText(item.quantity.toString())
            edtUnit.setText(item.unit)
        }
    }

    // returns the item based on the given name
    fun retrieveItem(name: String): Item {
        val cursor = db.query(
            "items",
            null,
            "name = \"${name}\"",
            null,
            null,
            null,
            null
        )
        with (cursor) {
            cursor.moveToNext()
            val category = cursor.getInt(1)
            val quantity = cursor.getInt(2)
            val unit     = cursor.getString(3)
            val item = Item(name, category, quantity, unit)
            return item
        }
    }

    override fun onClick(view: View?) {
        val name = findViewById<EditText>(R.id.edtName).text.toString()
        val quantity = findViewById<EditText>(R.id.edtQuantity).text.toString().toInt()
        val unit = findViewById<EditText>(R.id.edtUnit).text.toString()
        val category = findViewById<Spinner>(R.id.spnCategory).selectedItemPosition
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
        // TODO #6: write the code for the "update" operation
        else {
            try {
                db.execSQL(
                    """
                        UPDATE items SET
                            category = ${category},
                            quantity = ${quantity}, 
                            unit = "${unit}" 
                        WHERE name = "${name}"
                    """
                )
                Toast.makeText(
                    this,
                    "Shopping list item successfully updated!",
                    Toast.LENGTH_SHORT
                ).show()
            } catch (ex: Exception) {
                print(ex.toString())
                Toast.makeText(
                    this,
                    "Exception when trying to update the shopping list item!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        finish()
    }
}