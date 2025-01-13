package com.example.myapplicationtest

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val fruitsList = listOf<Fruit>(Fruit("Mango", "Bobo"),
        Fruit("Banana", "Keke"), Fruit("Apple", "Hehe"),
        Fruit("Kiwi", "Hola"), Fruit("Dragon fruit", "Loppy"),
        Fruit("Lemon", "Metro"), Fruit("Orange", "Mega"),
          Fruit("Pear", "Shiha"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.rv)
        recyclerView.setBackgroundColor(Color.YELLOW)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyRecyclerViewAdapter(
            fruitsList
        ) { selectedItem: Fruit ->
            listItemClicked(selectedItem)
        }
    }

    private fun listItemClicked(fruit: Fruit){
        Toast.makeText(this@MainActivity, "Supplier fruit is: ${fruit.supply}", Toast.LENGTH_LONG).show()
    }
}