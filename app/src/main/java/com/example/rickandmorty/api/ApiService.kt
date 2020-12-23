package com.example.rickandmorty.api

import com.example.rickandmorty.model.Character
import com.example.rickandmorty.model.CharactersResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("character/")
    fun getListCharacters(): Call<CharactersResponse>
}