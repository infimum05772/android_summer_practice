package com.itis.summerpractice

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.itis.summerpractice.databinding.FragmentAntisettingsBinding

class AntisettingsFragment : Fragment(R.layout.fragment_antisettings) {
    private var binding: FragmentAntisettingsBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAntisettingsBinding.bind(view)
        val msg = arguments?.getString("MESSAGE")
        if (msg != null) {
            Snackbar.make(view, msg, Snackbar.LENGTH_LONG).show()
        }
        binding?.run {
            backButton.setOnClickListener {
                arguments?.let { it1 -> findNavController().navigate(it1.getInt("ACTION")) }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
