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
        
    }

    // TODO #2: create the ItemAdapter inner class
    private inner class ItemAdapter(var items: List<Item>): RecyclerView.Adapter<ItemHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
            
        }

        override fun onBindViewHolder(holder: ItemHolder, position: Int) {
            
        }

        override fun getItemCount(): Int {
            return items.size
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO #3: create a list of items from the ShoppingList db
        

        // TODO #4: create the recycler view
       
    }
}