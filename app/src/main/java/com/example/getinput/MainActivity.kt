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

    fun calculateNumber(name: String): Pair<Int, Int> {
        val totalNumber = name.sumOf { charToNumber(it) }
        val characterCount = name.count { it.isLetter() }
        return Pair(totalNumber, characterCount)
    }

    fun updateText(view: View) {
        val editText = findViewById<EditText>(R.id.InputText)
        val textView = findViewById<TextView>(R.id.textView)
        val name = editText.text.toString()
        val (totalNumber, characterCount) = calculateNumber(name)
        val finalNumber = if (characterCount > 0) totalNumber / characterCount else 0
        val fortune = getFortune(finalNumber)
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
            10 -> "Get a new car"
            11 -> "Get a new motor"
            12 -> "White"
            13 -> "Curly Hair"
            14 -> "Jaw line"
            15 -> "Six pack"
            16 -> "Cat eyes"
            17 -> "Smooth skin"
            18 -> "Run fast"
            19 -> "Bat man"
            20 -> "Spider man"
            21 -> "You will discover Time travel soon"
            22 -> "High grade"
            23 -> "you will get 1 million dollars on lottery"
            24 -> "after you get up from bed you will get 2 meter height"
            25 -> "Crush accept"
            26 -> "Every dream come true"
            27 -> "Safe Travel"
            28 -> "Kung fu inside"
            // Add cases 4 to 28 here
            29 -> "A thrilling adventure awaits you."
            30 -> "You will discover a hidden talent within yourself."
            else -> "The stars are not clear on your fortune. Try again."
        }
    }


}
