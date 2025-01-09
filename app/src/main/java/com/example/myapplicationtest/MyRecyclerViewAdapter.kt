package com.example.myapplicationtest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerViewAdapter(val fruitsList: List<Fruit>) : RecyclerView.Adapter<MyViewHolder>(){

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
    }
}