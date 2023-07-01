package com.itis.summerpractice

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.itis.summerpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var startButton: Button? = null
    private var answer: String? = ""
    private val excMsg: String = "Invalid input data"
    private val maxHeight: Int = 250
    private val maxWeight: Int = 250
    private val maxAge: Int = 150
    private val maxNameLength: Int = 50

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState != null) {
            answer = savedInstanceState.getString("ANS")
        }
        val answerTextView = findViewById<TextView>(R.id.tv_answer)
        startButton = findViewById(R.id.btn_start)
        startButton?.setOnClickListener {
            val name = findViewById<EditText>(R.id.et_name).text.toString()
            if (name.isEmpty() || name.length > maxNameLength) {
                answerTextView.text = excMsg
                return@setOnClickListener
            }
            val age = findViewById<EditText>(R.id.et_age).text.toString().toIntOrNull()
            if (age == null || age >= maxAge || age <= 0) {
                answerTextView.text = excMsg
                return@setOnClickListener
            }
            val height = findViewById<EditText>(R.id.et_height).text.toString().toIntOrNull()
            if (height == null || height >= maxHeight || height <= 0) {
                answerTextView.text = excMsg
                return@setOnClickListener
            }
            val weight = findViewById<EditText>(R.id.et_weight).text.toString().toIntOrNull()
            if (weight == null || weight >= maxWeight || weight <= 0) {
                answerTextView.text = excMsg
                return@setOnClickListener
            }
            answer =
                "#ff" + getNamePart(name) + getAgePart(age) + getHeightWeightPart(height, weight)
            startButton!!.setBackgroundColor(Color.parseColor(answer))
            answerTextView.text = "Answer: $answer"
        }
    }

    fun getNamePart(string: String): String {
        val text = string.trim()
        var res = 0
        var x = 1
        val mod = 256
        for (element in text) {
            res += (x * element.code * element.code) % mod
            x *= element.code
        }
        val strRes = (res % mod).toString(16)
        return if (strRes.length < 2) "0$strRes" else strRes
    }

    fun getAgePart(num: Int): String {
        val res = ((num * num) % 256).toString(16)
        return if (res.length < 2) "0$res" else res
    }

    fun getHeightWeightPart(height: Int, weight: Int): String {
        val res = ((height * height + weight * weight) % 256).toString(16)
        return if (res.length < 2) "0$res" else res
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("ANS", answer)
    }
}
