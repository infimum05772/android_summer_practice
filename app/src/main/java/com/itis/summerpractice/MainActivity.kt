package com.itis.summerpractice

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var startButton: Button? = null
    private var answer: String? = ""
    private val excMsg: String = "Invalid input data"
    private val maxHeight: Int = 250
    private val maxWeight: Int = 250
    private val maxAge: Int = 150
    private val maxNameLength: Int = 50;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState != null){
            answer = savedInstanceState.getString("ANS")
        }
        val answerTextView = findViewById<TextView>(R.id.answer)
        startButton = findViewById(R.id.button)
        startButton?.setOnClickListener {
        val name = findViewById<EditText>(R.id.name).text.toString()
        if (name.isEmpty() || name.length > maxNameLength){
            answerTextView.text = excMsg
            return@setOnClickListener
        }
        val age = findViewById<EditText>(R.id.age).text.toString()
        if (age.isEmpty() || Integer.parseInt(age) >= maxAge || Integer.parseInt(age) <= 0){
            answerTextView.text = excMsg
            return@setOnClickListener
        }
        val height = findViewById<EditText>(R.id.height).text.toString()
        if (height.isEmpty() || Integer.parseInt(height) >= maxHeight || Integer.parseInt(height) <= 0){
            answerTextView.text = excMsg
            return@setOnClickListener
        }
        val weight = findViewById<EditText>(R.id.weight).text.toString()
        if (weight.isEmpty() || Integer.parseInt(weight) >= maxWeight || Integer.parseInt(weight) <= 0){
            answerTextView.text = excMsg
            return@setOnClickListener
        }
        answer = "#ff" + getNamePart(name) + getAgePart(age) + getHeightWeightPart(height, weight)
        startButton!!.setBackgroundColor(Color.parseColor(answer))
        answerTextView.text = "Answer: $answer"
        }
    }
    fun getNamePart(string: String): String{
        val text = string.trim()
        var res = 0
        var x = 1
        val mod = 256
        for (element in text){
            res += (x * element.code) % mod
            x *= 2
        }
        val strRes = (res % mod).toString(16)
        return if (strRes.length < 2) "0$strRes" else strRes
    }
    fun getAgePart(string: String): String{
        val res = ((Integer.parseInt(string) * 13) % 256).toString(16)
        return if  (res.length < 2) "0$res" else res
    }

    fun getHeightWeightPart(height: String, weight: String): String{
        val res = (((Integer.parseInt(height) + Integer.parseInt(weight)) * 13) % 256).toString(16)
        return if  (res.length < 2) "0$res" else res
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("ANS", answer)
    }
    override fun onDestroy() {
        super.onDestroy()
    }
}