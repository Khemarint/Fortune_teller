package com.example.getinput

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun charToNumber(c: Char): Int {
        val lowerCaseChar = c.toLowerCase()
        return when (lowerCaseChar) {
            'a', 'j', 's' -> 1
            'b', 'k', 't' -> 2
            'c', 'l', 'u' -> 3
            'd', 'm', 'v' -> 4
            'e', 'n', 'w' -> 5
            'f', 'o', 'x' -> 6
            'g', 'p', 'y' -> 7
            'h', 'q', 'z' -> 8
            'i', 'r' -> 9
            else -> 0
        }
    }

    fun calculateNumber(name: String): Int {
        return name.sumOf { charToNumber(it) }
    }


    fun updateText(view: View) {
        val editText = findViewById<EditText>(R.id.InputText)
        val textView = findViewById<TextView>(R.id.textView)
        val name = editText.text.toString()
        val totalNumber = calculateNumber(name)
        val fortune = getFortune(totalNumber)
        textView.text = fortune
    }


    fun getFortune(number: Int): String {
        return when (number) {
            1 -> "Great opportunities are on the horizon."
            2 -> "Expect good news to come your way soon."
            3 -> "Someone close to you has a secret to share."
            4 -> "Sexy"
            5 -> "Hot"
            6 -> "Genius"
            7 -> "Strong"
            8 -> "Handsome"
            9 -> "Gay"
            10 -> "Big Dick"
            11 -> "Black"
            12 -> "White"
            13 -> "Curly Hair"
            14 -> "Jaw line"
            15 -> "Six pack"
            // Add cases 4 to 28 here
            29 -> "A thrilling adventure awaits you."
            30 -> "You will discover a hidden talent within yourself."
            else -> "The stars are not clear on your fortune. Try again."
        }
    }


}
