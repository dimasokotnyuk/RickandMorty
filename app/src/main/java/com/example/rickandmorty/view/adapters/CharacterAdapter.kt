package com.example.rickandmorty.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.R
import com.example.rickandmorty.model.Character
import com.example.rickandmorty.model.CharactersResponse

class CharacterAdapter : RecyclerView.Adapter<CharacterViewHolder>() {

    var data: List<Character> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bindData(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setDataCharacter(list: List<Character>){
        data = list
        notifyDataSetChanged()
    }
}