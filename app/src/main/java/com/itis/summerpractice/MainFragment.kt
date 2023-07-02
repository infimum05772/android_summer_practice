package com.itis.summerpractice

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.itis.summerpractice.databinding.FragmentMainBinding

class MainFragment: Fragment(R.layout.fragment_main) {
    private var binding: FragmentMainBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)
        binding?.run {
            antisettingsButton.setOnClickListener {
                findNavController().navigate(R.id.action_mainFragment_to_antisettingsFragment, createBundle())
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
    companion object {
        fun createBundle(): Bundle{
            val bundle = Bundle()
            bundle.putString("MESSAGE", "main fragment")
            bundle.putInt("ACTION", R.id.action_antisettingsFragment_to_mainFragment)
            return bundle
        }
    }
}
