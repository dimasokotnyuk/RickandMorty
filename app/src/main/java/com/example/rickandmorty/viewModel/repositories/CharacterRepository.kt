package com.example.rickandmorty.viewModel.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.rickandmorty.api.RetrofitClient
import com.example.rickandmorty.model.Character
import com.example.rickandmorty.model.CharactersResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object CharacterRepository {

    fun getCharacterList(): LiveData<CharactersResponse> {
        val data: MutableLiveData<CharactersResponse> = MutableLiveData<CharactersResponse>()

        RetrofitClient.provideApiService.getListCharacters().enqueue(
            object : Callback<CharactersResponse> {
                override fun onResponse(
                    call: Call<CharactersResponse>,
                    response: Response<CharactersResponse>
                ) {
                    data.value = response.body()
                    Log.i("mylog", "onResponse")
                }

                override fun onFailure(call: Call<CharactersResponse>, t: Throwable) {
                    Log.i("mylog", "onFailure")
                }
            }
        )
        return data
    }
}