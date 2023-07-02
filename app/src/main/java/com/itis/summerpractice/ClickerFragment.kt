package com.itis.summerpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.itis.summerpractice.databinding.FragmentClickerBinding

class ClickerFragment : Fragment(R.layout.fragment_clicker) {
    private var binding: FragmentClickerBinding? = null
    var count: Int = 0
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentClickerBinding.bind(view)

        binding?.run {
            button.setOnClickListener {
                count++
                tvCount.text = "$count"
            }
            antibutton.setOnClickListener {
                count = 0
                tvCount.text = "$count"
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}
