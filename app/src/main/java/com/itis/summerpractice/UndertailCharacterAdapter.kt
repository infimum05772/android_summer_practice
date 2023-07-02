package com.itis.summerpractice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.itis.summerpractice.databinding.ItemUndertailCharacterBinding

class UndertailCharacterAdapter(
    private var list: List<UndertailCharacter>
): RecyclerView.Adapter<UndertailCharacterItem>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UndertailCharacterItem = UndertailCharacterItem(
        ItemUndertailCharacterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: UndertailCharacterItem, position: Int) {
        holder.onBind(list[position])
    }

}
