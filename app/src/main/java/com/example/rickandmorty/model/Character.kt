package com.example.rickandmorty.model

import com.google.gson.annotations.SerializedName



data class Character(
    @SerializedName("name") val name: String,
    @SerializedName("status") val characterIsLive: String,
    @SerializedName("image") val urlImageCharacter: String
)
