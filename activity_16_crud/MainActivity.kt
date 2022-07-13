package edu.msudenver.crud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

// TODO #1: add the OnClickListener interface
class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var recyclerView: RecyclerView
    lateinit var dbHelper: DBHelper

    // creates the ItemHolder inner class
    private inner class ItemHolder(view: View): RecyclerView.ViewHolder(view) {
        val txtItemName: TextView     = view.findViewById(R.id.txtItemName)
        val txtItemCategory: TextView = view.findViewById(R.id.txtItemCategory)
        val txtItemQuantityAndUnit: TextView = view.findViewById(R.id.txtItemQuantityAndUnit)
    }

    // creates the ItemAdapter inner class
    // TODO #2: add an OnClickListener parameter
    private inner class ItemAdapter(var items: List<Item>, var onClickListener: View.OnClickListener): RecyclerView.Adapter<ItemHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
            return ItemHolder(view, )
        }

        override fun onBindViewHolder(holder: ItemHolder, position: Int) {
            val item = items[position]
            holder.txtItemName.text = item.name
            holder.txtItemCategory.text = item.categoryAsString()
            holder.txtItemQuantityAndUnit.text = item.quantity.toString() + " " + item.unit

            // TODO #3: set the holder's listener
            holder.itemView.setOnClickListener(onClickListener)
        }

        override fun getItemCount(): Int {
            return items.size
        }
    }

    // populates the recycler view
    fun populateRecyclerView() {
        val db = dbHelper.readableDatabase
        val items = mutableListOf<Item>()
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
        recyclerView.adapter = ItemAdapter(items, this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // creates and populates the recycler view
        dbHelper = DBHelper(this)
        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        populateRecyclerView()

        // initializes the floating action button
        val fabCreate: FloatingActionButton = findViewById(R.id.fabCreate)
        fabCreate.setOnClickListener {
            // calls CreateUpdateActivity for create
            val intent = Intent(this, CreateUpdateActivity::class.java)
            intent.putExtra("op", CreateUpdateActivity.CREATE_OP)
            startActivity(intent)
        }
    }

    // this method is called when CreateUpdateActivity finishes
    override fun onResume() {
        super.onResume()
        populateRecyclerView()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable("dbHelper", dbHelper)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        dbHelper = if (savedInstanceState.containsKey("dbHelper")) savedInstanceState.getSerializable("dbHelper") as DBHelper else DBHelper(this)
    }

    // TODO #4: calls CreateUpdateActivity for update
    override fun onClick(view: View?) {
        if (view != null) {
            val name = view.findViewById<TextView>(R.id.txtItemName).text
            val intent = Intent(this, CreateUpdateActivity::class.java)
            intent.putExtra("op", CreateUpdateActivity.UPDATE_OP)
            intent.putExtra("name", name)
            startActivity(intent)
        }
    }
}