package com.dan.dogsapp.model.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResponseItem(
    @SerializedName("age")
    val age: Int,
    @SerializedName("description")
    val description: String,
    @SerializedName("dogName")
    val dogName: String,
    @SerializedName("image")
    val image: String
) : Parcelable