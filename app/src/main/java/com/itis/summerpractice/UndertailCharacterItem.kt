package com.itis.summerpractice

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.itis.summerpractice.databinding.ItemUndertailCharacterBinding

class UndertailCharacterItem(
    private  val binding: ItemUndertailCharacterBinding
): ViewHolder(binding.root) {

    fun onBind(character: UndertailCharacter){
        binding?.run {
            tvTitle.text = character.name
            tvDesc.text= character.description
        }
    }
}
