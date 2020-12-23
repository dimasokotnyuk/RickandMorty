package com.example.rickandmorty.model

import com.google.gson.annotations.SerializedName

data class CharactersResponse(
    @SerializedName("results") val results: List<Character>
)