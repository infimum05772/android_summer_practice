package com.itis.summerpractice

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.itis.summerpractice.databinding.FragmentPetBinding

class PetFragment : Fragment(R.layout.fragment_pet) {
    private var binding: FragmentPetBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPetBinding.bind(view)
        binding?.run {
            antisettingsButton.setOnClickListener {
                findNavController().navigate(R.id.action_petFragment_to_antisettingsFragment,
                    ColorFragment.createBundle()
                )
            }
            ivPet.setOnClickListener {
                Snackbar.make(view, "meow", Snackbar.LENGTH_SHORT).show()
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
            bundle.putString("MESSAGE", "pet fragment")
            bundle.putInt("ACTION", R.id.action_antisettingsFragment_to_petFragment)
            return bundle
        }
    }
}
