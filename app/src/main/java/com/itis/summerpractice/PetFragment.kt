package com.itis.summerpractice

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.itis.summerpractice.databinding.FragmentPetBinding

class PetFragment : Fragment(R.layout.fragment_pet) {
    private var binding: FragmentPetBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPetBinding.bind(view)
        binding?.run {
            ivPet.setOnClickListener {
                var toast = Toast.makeText(activity, "meow", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}
