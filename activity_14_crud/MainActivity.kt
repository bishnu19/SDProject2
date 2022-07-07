package edu.msudenver.crud

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    val items = mutableListOf<Item>()

    // TODO #1: create the ItemHolder inner class
    private inner class ItemHolder(view: View): RecyclerView.ViewHolder(view) {
        val txtItemName: TextView     = view.findViewById(R.id.txtItemName)
        val txtItemCategory: TextView = view.findViewById(R.id.txtItemCategory)
        val txtItemQuantityAndUnit: TextView = view.findViewById(R.id.txtItemQuantityAndUnit)
    }

    // TODO #2: create the ItemAdapter inner class
    private inner class ItemAdapter(var items: List<Item>): RecyclerView.Adapter<ItemHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
            return ItemHolder(view)
        }

        override fun onBindViewHolder(holder: ItemHolder, position: Int) {
            val item = items[position]
            holder.txtItemName.text = item.name
            holder.txtItemCategory.text = item.categoryAsString()
            holder.txtItemQuantityAndUnit.text = item.quantity.toString() + " " + item.unit
        }

        override fun getItemCount(): Int {
            return items.size
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO #3: create a list of items from the ShoppingList db
        val dbHelper = DBHelper(this)
        val db = dbHelper.readableDatabase
        val cursor = db.query(
            "items",
            null,
            null,
            null,
            null,
            null,
            null
        )
        with (cursor) {
            while (moveToNext()) {
                val name    = getString(0)
                val category = getInt(1)
                val quantity = getInt(2)
                val unit     = getString(3)
                val item = Item(name, category, quantity, unit)
                items.add(item)
            }
        }

        // TODO #4: create the recycler view
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ItemAdapter(items)
    }
}