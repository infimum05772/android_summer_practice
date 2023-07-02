package com.itis.summerpractice

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
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
        adapter = UndertailCharacterAdapter(UndertaleCharacterRepository.list)
        binding?.rvUndertail?.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
