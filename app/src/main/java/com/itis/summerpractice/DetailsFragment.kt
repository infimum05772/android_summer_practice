package com.itis.summerpractice

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.itis.summerpractice.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment(R.layout.fragment_details){
    private var binding: FragmentDetailsBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailsBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
