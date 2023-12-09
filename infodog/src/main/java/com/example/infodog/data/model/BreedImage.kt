package com.example.infodog.data.model

import com.google.gson.annotations.SerializedName

data class BreedImage(
    @SerializedName("id") val id: String,
    @SerializedName("url") val url: String
)
