package com.itis.summerpractice

import android.graphics.drawable.Drawable
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.RequestOptionsFactory
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.itis.summerpractice.databinding.ItemUndertailCharacterBinding

class UndertailCharacterItem(
    private  val binding: ItemUndertailCharacterBinding,
    private val glide: RequestManager,
    private val onItemClick: (UndertailCharacter) -> Unit
): ViewHolder(binding.root) {

    private val options: RequestOptions = RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL)

    fun onBind(character: UndertailCharacter){
        binding?.run {
            tvTitle.text = character.name
            tvDesc.text= character.description
            glide
                .load(character.url)
                .placeholder(R.drawable.loading)
                .error(R.drawable.error)
                .apply(options)
                .into(ivImage)
            root.setOnClickListener {
                onItemClick(character)
            }
        }
    }
}
