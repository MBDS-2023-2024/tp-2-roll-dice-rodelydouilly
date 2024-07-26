package com.example.diceroller

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    @SuppressLint("ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice objects with 6 sides and roll them
        val dice1 = Dice(6)
        val diceRoll1 = dice1.roll()

        val dice2 = Dice(6)
        val diceRoll2 = dice2.roll()

        // Update the screen with the dice rolls
        val resultTextView1: TextView = findViewById(R.id.textView1)
        resultTextView1.text = diceRoll1.toString()

        val resultTextView2: TextView = findViewById(R.id.textView2)
        resultTextView2.text = diceRoll2.toString()

        // Check if the user wins
        if (diceRoll1 == diceRoll2) {
            Toast.makeText(this, "Félicitations ! Vous avez gagné !", Toast.LENGTH_SHORT).show()
        }
    }
}

// Class Dice with private variable
class Dice(private val numSides: Int) {

    // Random function roll()
    fun roll(): Int {
        return (1..numSides).random()
    }

}
