package com.kharismarizqii.recyclerviewexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_superhero.view.*

class SuperHeroAdapter(private val list: ArrayList<SuperHero>) : RecyclerView.Adapter<SuperHeroAdapter.SuperHerpViewHolder>(){
    inner class SuperHerpViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(superHero: SuperHero){
            with(itemView){
                tv_name.text = superHero.name
                tv_desc.text = superHero.desc
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHerpViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_superhero, parent, false)
        return SuperHerpViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: SuperHerpViewHolder, position: Int) {
        holder.bind(list[position])
    }

}