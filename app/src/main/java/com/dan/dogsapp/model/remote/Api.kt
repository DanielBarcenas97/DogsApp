package com.dan.dogsapp.model.remote

import com.dan.dogsapp.model.models.ResponseDog
import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET("945366962796773376/")
    suspend fun getListDogs(): Response<ResponseDog>
}