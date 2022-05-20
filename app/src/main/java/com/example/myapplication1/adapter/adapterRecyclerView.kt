package com.example.myapplication1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication1.R

class adapterRecyclerView(private val context: Context, private val listener: () -> Unit) :
    RecyclerView.Adapter<adapterRecyclerView.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val name = view.findViewById<TextView>(R.id.name);
        val price = view.findViewById<TextView>(R.id.price);

        fun Crete(model: Model,listener: () -> Unit) {
            price.text = model.price
            name.text = model.name
            itemView.setOnClickListener { listener() }
        }
    }

    private val image = intArrayOf(R.drawable.foo1);

    private val list = listOf<Model>(
        Model("N1,900", "Veggie tomato mix", R.drawable.foo1),
        Model("N1,900", "Egg and cucmber...", R.drawable.foo1),
        Model("N1,900", "Veggie tomato mix", R.drawable.foo1),
        Model("N1,900", "Egg and cucmber...", R.drawable.foo1),
        Model("N1,900", "Veggie tomato mix", R.drawable.foo1),
        Model("N1,900", "Egg and cucmber...", R.drawable.foo1),
        Model("N1,900", "Veggie tomato mix", R.drawable.foo1),
        Model("N1,900", "Egg and cucmber...", R.drawable.foo1)
    )

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.card, parent, false))

    override fun onBindViewHolder(holder: adapterRecyclerView.ViewHolder, position: Int) {
        holder.Crete(list[position],listener)
    }

    override fun getItemCount(): Int = list.size
}

class Model(val price: String, val name: String, val image: Int)