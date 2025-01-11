package com.example.myapplicationtest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerViewAdapter(
    private val fruitsList: List<Fruit>,
    private val clickListener: (Fruit)-> Unit
) : RecyclerView.Adapter<MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item, parent, false)

        return MyViewHolder(listItem)
    }

    override fun getItemCount(): Int {
        return fruitsList.size //go to fun onBindViewHolder() n times
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val fruit = fruitsList[position]
        holder.bindData(fruit)
    }

}

class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view){
    fun bindData(fruit: Fruit){
        val viewName = view.findViewById<TextView>(R.id.tvName)
        viewName.text = fruit.name

        view.setOnClickListener {
            Toast.makeText(view.context, "Selected fruit is: ${fruit.name}", Toast.LENGTH_LONG).show()
        }
    }
}