package com.itis.summerpractice

import android.graphics.Typeface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.itis.summerpractice.databinding.FragmentNotesBinding

class NotesFragment : Fragment(R.layout.fragment_notes) {
    private var binding: FragmentNotesBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNotesBinding.bind(view)
        binding?.run {
            antisettingsButton.setOnClickListener {
                findNavController().navigate(R.id.action_notesFragment_to_antisettingsFragment,
                    ColorFragment.createBundle()
                )
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
            bundle.putString("MESSAGE", "notes fragment")
            bundle.putInt("ACTION", R.id.action_antisettingsFragment_to_notesFragment)
            return bundle
        }
    }
}
