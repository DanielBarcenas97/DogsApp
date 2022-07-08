package com.dan.dogsapp.model.repository

import com.dan.dogsapp.model.models.ResponseDog


class DogsUseCase(
    private val repository:RepositoryDogs = RepositoryDogs()
) {

    suspend  fun getList(): ResponseDog? {
        return repository.getDogs()
    }
}