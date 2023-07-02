package com.itis.summerpractice

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.itis.summerpractice.databinding.FragmentListBinding

class ListFragment : Fragment(R.layout.fragment_list) {
    private var binding: FragmentListBinding? = null
    private var adapter: UndertailCharacterAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentListBinding.bind(view)
        initAdapter()
    }

    private fun initAdapter(){
        adapter = UndertailCharacterAdapter(
            UndertaleCharacterRepository.list,
            Glide.with(this)
        ) { character ->
            findNavController().navigate(R.id.action_listFragment_to_detailsFragment, createBundle(character))
        }
        binding?.rvUndertail?.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    fun createBundle(character: UndertailCharacter): Bundle{
        val bundle = Bundle()
        bundle.putInt("CHARACTER_ID", character.id)
        return bundle
    }
}
