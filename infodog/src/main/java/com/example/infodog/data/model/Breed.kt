package com.example.infodog.data.model

import com.google.gson.annotations.SerializedName

data class Breed(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: BreedImage
)
