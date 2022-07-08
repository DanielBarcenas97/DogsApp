package com.dan.dogsapp.ui.fragments


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dan.dogsapp.model.models.ResponseDog
import com.dan.dogsapp.model.repository.DogsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private var listUseCase = DogsUseCase()

    private val _loading = MutableStateFlow(true)
    val loading : StateFlow<Boolean> = _loading.asStateFlow()

    private val _listDogs = MutableStateFlow<ResponseDog?>(null)
    val listDogs : StateFlow<ResponseDog?> = _listDogs.asStateFlow()


    init {
        viewModelScope.launch {
            _loading.value = true
           _listDogs.value = listUseCase.getList()
            _loading.value = false
        }
    }



}