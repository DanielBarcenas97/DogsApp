package com.dan.dogsapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.dan.dogsapp.databinding.FragmentDetailBinding
import com.dan.dogsapp.model.models.ResponseItem

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.takeIf { it.containsKey(ARG_OBJECT) }?.apply {

            val dog = this.getParcelable<ResponseItem>(ARG_OBJECT)

            binding.tvName.text = dog?.dogName
            binding.tvNameComplete.text = dog?.dogName
            binding.tvAlias.text = dog?.age.toString()

            binding.tvDate.text = dog?.description

            Glide.with(requireContext())
                .load(dog?.image)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .into(binding.ivPhoto)

        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object{
        private const val ARG_OBJECT = "dog"
    }
}