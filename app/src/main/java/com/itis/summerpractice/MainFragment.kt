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



//        binding?.run {
//            btnToGlasses.setOnClickListener {
//                findNavController().navigate(R.id.action_mainFragment_to_clickerFragment)
//            }
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
//    companion object {
//
//        fun createBundle(): Bundle{
//            val bundle = Bundle()
//            return bundle
//        }
//    }
}
