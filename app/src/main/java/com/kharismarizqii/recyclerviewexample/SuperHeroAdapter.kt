package com.kharismarizqii.recyclerviewexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_superhero.view.*

class SuperHeroAdapter(private val list: ArrayList<SuperHero>) : RecyclerView.Adapter<SuperHeroAdapter.SuperHerpViewHolder>(){

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    inner class SuperHerpViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(superHero: SuperHero){
            with(itemView){
                tv_name.text = superHero.name
                tv_desc.text = superHero.desc

                itemView.setOnClickListener { onItemClickCallback?.onItemClicked(superHero) }
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

    interface OnItemClickCallback{
        fun onItemClicked(data: SuperHero)
    }

}