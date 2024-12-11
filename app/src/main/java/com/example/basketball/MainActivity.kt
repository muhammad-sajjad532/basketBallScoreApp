package com.example.basketball

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private val basketBallScore = basketBallScore() // Use your class name for managing scores

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find views
        val mainLayout = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.main)
        val teamAScore = findViewById<TextView>(R.id.team_a_score)
        val teamBScore = findViewById<TextView>(R.id.team_b_score)
        val teamAPlusOne = findViewById<Button>(R.id.team_a_plus_one)
        val teamAPlusThree = findViewById<Button>(R.id.team_a_plus_three)
        val teamBPlusOne = findViewById<Button>(R.id.team_b_plus_one)
        val teamBPlusThree = findViewById<Button>(R.id.team_b_plus_three)

        // Handle window insets for edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(mainLayout) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Update scores on the screen
        fun updateScores() {
            teamAScore.text = basketBallScore.teamAScore.toString()
            teamBScore.text = basketBallScore.teamBScore.toString()
        }

        // Button listeners for Team A
        teamAPlusOne.setOnClickListener {
            basketBallScore.addPointsToTeamA(1)
            updateScores()
        }
        teamAPlusThree.setOnClickListener {
            basketBallScore.addPointsToTeamA(3)
            updateScores()
        }

        // Button listeners for Team B
        teamBPlusOne.setOnClickListener {
            basketBallScore.addPointsToTeamB(1)
            updateScores()
        }
        teamBPlusThree.setOnClickListener {
            basketBallScore.addPointsToTeamB(3)
            updateScores()
        }

        // Reset button listener
        resetButton.setOnClickListener {
            basketBallScore.teamAScore = 0
            basketBallScore.teamBScore = 0
            updateScores()
        }
    }
}
