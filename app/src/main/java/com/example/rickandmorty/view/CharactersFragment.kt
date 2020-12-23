package com.example.rickandmorty.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.R
import com.example.rickandmorty.model.Character
import com.example.rickandmorty.model.CharactersResponse
import com.example.rickandmorty.view.adapters.CharacterAdapter
import com.example.rickandmorty.viewModel.viewModels.CharacterViewModel

class CharactersFragment : Fragment(R.layout.fragment_characters) {

    companion object {
        fun newInstance() = CharactersFragment().apply {
        }
    }

    private var adapter: CharacterAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler: RecyclerView = view.findViewById(R.id.container)
        adapter = CharacterAdapter()
        recycler.adapter = adapter
        val viewModel = ViewModelProvider(this).get(CharacterViewModel::class.java)
        observableViewModel(viewModel)
    }

    private fun observableViewModel(viewModel: CharacterViewModel) {
        viewModel.getCharacterListObservable().observe(this, Observer<CharactersResponse>() {
            if (it != null) {
                adapter?.setDataCharacter(it.results)
            }
        })


    }
}