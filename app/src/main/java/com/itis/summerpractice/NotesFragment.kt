package com.itis.summerpractice

import android.graphics.Typeface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.itis.summerpractice.databinding.FragmentNotesBinding

class NotesFragment : Fragment(R.layout.fragment_notes) {
    private var binding: FragmentNotesBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNotesBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
