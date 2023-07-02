package com.itis.summerpractice

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.itis.summerpractice.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment(R.layout.fragment_details){
    private var binding: FragmentDetailsBinding? = null
    private val options: RequestOptions = RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailsBinding.bind(view)
        val id = arguments?.getInt("CHARACTER_ID")

        binding?.run {
            val character = UndertaleCharacterRepository.list.first{it.id == id}
            tvName.text = character.name
            tvDescription.text = character.description
            tvPlace.text = "location:${character.place}"
            tvAtk.text = "ATK:${character.ATK}"
            tvHp.text = "HP:${character.HP}"
            Glide.with(binding!!.root)
                .load(character.url)
                .placeholder(R.drawable.loading)
                .error(R.drawable.error)
                .apply(options)
                .into(ivCharacterImage)
            ibtnBack.setOnClickListener {
                findNavController().navigate(R.id.action_detailsFragment_to_listFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
