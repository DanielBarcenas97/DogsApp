package com.dan.dogsapp.model.remote

import com.dan.dogsapp.model.models.ResponseDog
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class Service(
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default
) {

    private val retrofit = Retrofit.getRetrofit()
    private val client = retrofit.create(Api::class.java)

    suspend fun getDogs(): ResponseDog? {
        return withContext(dispatcher) {
            try {
                val response = client.getListDogs()
                if (response.isSuccessful) {
                    response.body()
                } else {
                    null
                }
            }catch (exception: Exception){
                return@withContext null
            }
        }
    }

}