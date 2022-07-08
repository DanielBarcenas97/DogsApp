package com.dan.dogsapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.dan.dogsapp.R
import com.dan.dogsapp.databinding.FragmentMainBinding
import com.dan.dogsapp.model.models.ResponseItem
import com.dan.dogsapp.ui.fragments.adapter.DogsAdapter
import kotlinx.coroutines.launch

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val mViewModelList: MainViewModel by viewModels()

    private lateinit var adapter: DogsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            mainRV.layoutManager = LinearLayoutManager(activity)
            adapter = DogsAdapter { hero -> onClickItem(hero) }
            mainRV.adapter = adapter

            viewLifecycleOwner.lifecycleScope.launch {
                viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED){
                    mViewModelList.state.collect{ state ->
                        progressCircular.isVisible = state.loading
                        state.listDogs?.let { adapter.setList(it) }
                    }
                }
            }
        }
    }

    private fun onClickItem(heroModel: ResponseItem) {
        val bundle = Bundle()
        bundle.putParcelable("dog", heroModel)
        findNavController().navigate(R.id.action_mainFragment_to_detailFragment,bundle)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}