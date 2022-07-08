package com.dan.dogsapp.model.models


import com.google.gson.annotations.SerializedName

data class ResponseItem(
    @SerializedName("age")
    val age: Int,
    @SerializedName("description")
    val description: String,
    @SerializedName("dogName")
    val dogName: String,
    @SerializedName("image")
    val image: String
)