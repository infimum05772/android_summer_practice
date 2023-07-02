package com.itis.summerpractice

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.itis.summerpractice.databinding.FragmentColorBinding

class ColorFragment : Fragment(R.layout.fragment_color) {
    private var binding: FragmentColorBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentColorBinding.bind(view)

        binding?.run {
            antisettingsButton.setOnClickListener {
                findNavController().navigate(R.id.action_colorFragment_to_antisettingsFragment,
                    createBundle()
                )
            }
            circleButton.setOnClickListener {
                val red = etRed.text.toString().toIntOrNull()
                val green = etGreen.text.toString().toIntOrNull()
                val blue = etBlue.text.toString().toIntOrNull()
                if (red == null || green == null || blue == null || !(validateColor(red) && validateColor(green) && validateColor(blue))){
                    tvExc.text = "invalid colors :)"
                    return@setOnClickListener
                }
                circleButton.setBackgroundColor(Color.parseColor(toHexColor(red, green, blue)))
                tvExc.text = ""
            }
        }
    }

    fun toHexColor(red:Int,green:Int,blue:Int):String{
        val redStr = red.toString(16)
        val redPart = if (redStr.length < 2) "0$redStr" else redStr
        val greenStr = green.toString(16)
        val greenPart = if (greenStr.length < 2) "0$greenStr" else greenStr
        val blueStr = blue.toString(16)
        val bluePart = if (blueStr.length < 2) "0$blueStr" else blueStr
        return "#ff$redPart$greenPart$bluePart"
    }
    fun validateColor(num:Int?):Boolean{
        if (num == null || num < 0 || num > 255){
            return false
        }
        return true
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
    companion object {
        fun createBundle(): Bundle{
            val bundle = Bundle()
            bundle.putString("MESSAGE", "color fragment")
            bundle.putInt("ACTION", R.id.action_antisettingsFragment_to_colorFragment)
            return bundle
        }
    }
}
