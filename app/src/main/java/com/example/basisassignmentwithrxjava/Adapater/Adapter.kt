package com.example.basisassignmentwithrxjava.Adapater

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.basisassignmentwithrxjava.Model.Data
import com.example.basisassignmentwithrxjava.R


class Adapter(private var list: List<Data>) : RecyclerView.Adapter<Adapter.FoodViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
       return FoodViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.each_row,parent,false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food=list[position]
        holder.price.text=food.id
        holder.name.text=food.text

    }

    fun setData(foodList: ArrayList<Data>)
    {
        this.list=foodList
        notifyDataSetChanged()
    }

    inner class FoodViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
        val name:TextView=itemView.findViewById(R.id.name)
        val price:TextView=itemView.findViewById(R.id.price)

    }
}
