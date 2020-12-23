package com.example.rickandmorty.viewModel.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmorty.model.Character
import com.example.rickandmorty.model.CharactersResponse
import com.example.rickandmorty.viewModel.repositories.CharacterRepository

class CharacterViewModel : ViewModel() {

    private val projectListObservable: LiveData<CharactersResponse> =
        CharacterRepository.getCharacterList()

    fun getCharacterListObservable(): LiveData<CharactersResponse> {
        return projectListObservable
    }
}