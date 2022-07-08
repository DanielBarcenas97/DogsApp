package com.dan.dogsapp.ui.fragments.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dan.dogsapp.R
import com.dan.dogsapp.model.models.ResponseItem

class SuperHeroAdapter(private val onClickListener: (ResponseItem) -> Unit):RecyclerView.Adapter<SuperHeroViewHolder>() {

    var superHeroList: MutableList<ResponseItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SuperHeroViewHolder(layoutInflater.inflate(R.layout.item, parent, false))
    }

    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        val item = superHeroList[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int = superHeroList.size

    fun setHeroList(heroModel: MutableList<ResponseItem>) {
        superHeroList = heroModel
        notifyDataSetChanged()
    }
}