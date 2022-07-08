package com.dan.dogsapp.ui.fragments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dan.dogsapp.model.models.ResponseDog
import com.dan.dogsapp.domain.DogsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private var listUseCase = DogsUseCase()

    private val _state = MutableStateFlow(UiState())
    val state : StateFlow<UiState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.update { it.copy(loading = true) }
            val listDogs = listUseCase.getList()
            _state.update { it.copy(listDogs = listDogs) }
            _state.update { it.copy(loading = false) }
        }
    }

    data class UiState(
        val loading : Boolean = false ,
        val listDogs : ResponseDog? = null
    )

}