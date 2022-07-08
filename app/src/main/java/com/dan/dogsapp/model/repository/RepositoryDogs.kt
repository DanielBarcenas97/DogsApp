package com.dan.dogsapp.model.repository

import com.dan.dogsapp.model.models.ResponseDog
import com.dan.dogsapp.model.remote.Service

class RepositoryDogs {

    private val api = Service()

    suspend fun getDogs(): ResponseDog? {
        return api.getDogs()
    }
}