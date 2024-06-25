package com.example.tictactoe

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var flag = 0
    var count = 0
    // Define the buttons
    // Define the buttons
    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    private lateinit var btn4: Button
    private lateinit var btn5: Button
    private lateinit var btn6: Button
    private lateinit var btn7: Button
    private lateinit var btn8: Button
    private lateinit var btn9: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the buttons
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)

        setButtonListeners()
    }

    private fun setButtonListeners() {
        btn1.setOnClickListener { check(it) }
        btn2.setOnClickListener { check(it) }
        btn3.setOnClickListener { check(it) }
        btn4.setOnClickListener { check(it) }
        btn5.setOnClickListener { check(it) }
        btn6.setOnClickListener { check(it) }
        btn7.setOnClickListener { check(it) }
        btn8.setOnClickListener { check(it) }
        btn9.setOnClickListener { check(it) }
    }

    fun check(view: android.view.View) {
        val btnCurrent = view as Button
        if (btnCurrent.text == "") {
            count++
            btnCurrent.text = if (flag == 0) "X" else "O"
            flag = 1 - flag

            val b1 = btn1.text.toString()
            val b2 = btn2.text.toString()
            val b3 = btn3.text.toString()
            val b4 = btn4.text.toString()
            val b5 = btn5.text.toString()
            val b6 = btn6.text.toString()
            val b7 = btn7.text.toString()
            val b8 = btn8.text.toString()
            val b9 = btn9.text.toString()

            when {
                b1 == b2 && b2 == b3 && b3 != "" -> announceWinner(b1)
                b4 == b5 && b5 == b6 && b6 != "" -> announceWinner(b4)
                b7 == b8 && b8 == b9 && b9 != "" -> announceWinner(b7)
                b1 == b4 && b4 == b7 && b7 != "" -> announceWinner(b1)
                b2 == b5 && b5 == b8 && b8 != "" -> announceWinner(b2)
                b3 == b6 && b6 == b9 && b9 != "" -> announceWinner(b3)
                b1 == b5 && b5 == b9 && b9 != "" -> announceWinner(b1)
                b3 == b5 && b5 == b7 && b7 != "" -> announceWinner(b3)
                count == 9 -> Toast.makeText(this, "Match is drawn", Toast.LENGTH_LONG).show()
                    .also { newGame() }
            }
        }
    }

    private fun announceWinner(winner: String) {
        Toast.makeText(this, "Winner is: $winner", Toast.LENGTH_LONG).show()
        newGame()
    }

    private fun newGame() {
        btn1.text = ""
        btn2.text = ""
        btn3.text = ""
        btn4.text = ""
        btn5.text = ""
        btn6.text = ""
        btn7.text = ""
        btn8.text = ""
        btn9.text = ""
        flag = 0
        count = 0
    }

}
