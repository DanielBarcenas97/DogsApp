package com.dan.dogsapp.ui.fragments.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.dan.dogsapp.databinding.ItemBinding
import com.dan.dogsapp.model.models.ResponseItem

class DogsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemBinding.bind(view)

    fun render(heroModel: ResponseItem, onClickListener: (ResponseItem) -> Unit) {
        binding.heroNameTV.text = heroModel.dogName

        binding.tvData.text = heroModel.description

        Glide.with(binding.imgCard.context)
            .load(heroModel.image)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
            .into(binding.imgCard)

        itemView.setOnClickListener {
            onClickListener(heroModel) }
    }
}