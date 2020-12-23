package com.example.rickandmorty.view.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.example.rickandmorty.R
import com.example.rickandmorty.model.Character

class CharacterViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {

    private val imageCharacter: ImageView = listItemView.findViewById(R.id.image_character)
    private val nameCharacter: TextView = listItemView.findViewById(R.id.tv_character_name)
    private val characterIsLive: TextView = listItemView.findViewById(R.id.tv_character_is_live)

    fun bindData(character: Character) {
        nameCharacter.text =character.name
        characterIsLive.text = "status: ${character.characterIsLive}"

        Glide
            .with(itemView.context)
            .load(character.urlImageCharacter)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .transform(CircleCrop())
            .override(350, 350)
            .into(imageCharacter)
    }
}