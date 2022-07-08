package com.dan.dogsapp.ui.fragments.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dan.dogsapp.R
import com.dan.dogsapp.model.models.ResponseItem

class DogsAdapter(private val onClickListener: (ResponseItem) -> Unit):RecyclerView.Adapter<DogsViewHolder>() {

    var dogsList: MutableList<ResponseItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return DogsViewHolder(layoutInflater.inflate(R.layout.item, parent, false))
    }

    override fun onBindViewHolder(holder: DogsViewHolder, position: Int) {
        val item = dogsList[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int = dogsList.size

    fun setList(dogs: MutableList<ResponseItem>) {
        dogsList = dogs
        notifyDataSetChanged()
    }
}