package com.itis.summerpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.itis.summerpractice.databinding.FragmentClickerBinding

class ClickerFragment : Fragment(R.layout.fragment_clicker) {
    private var binding: FragmentClickerBinding? = null
    var count: Int = 0
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentClickerBinding.bind(view)

        if (savedInstanceState != null) {
            count = savedInstanceState.getInt("ARG_COUNT")
        }

        binding?.run {
            button.setOnClickListener {
                count++
                tvCount.text = "$count"
            }
            antibutton.setOnClickListener {
                count = 0
                tvCount.text = "$count"
            }
            antisettingsButton.setOnClickListener {
                findNavController().navigate(R.id.action_clickerFragment_to_antisettingsFragment,
                    createBundle()
                )
            }
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("ARG_COUNT", count)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
    companion object {
        fun createBundle(): Bundle{
            val bundle = Bundle()
            bundle.putString("MESSAGE", "clicker fragment")
            bundle.putInt("ACTION", R.id.action_antisettingsFragment_to_clickerFragment)
            return bundle
        }
    }
}
