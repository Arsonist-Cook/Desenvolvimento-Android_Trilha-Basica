package com.example.android.courtcounter

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var scoreTeamA: Int = 0
    var scoreTeamB: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        displayForTeamA(scoreTeamA)
    }

    /**
     * Displays the given score for Team A.
     */
    private fun displayForTeamA(score: Int) {
        val scoreView: TextView = findViewById(R.id.team_a_score)
        scoreView.text = "$score"
    }

    private fun displayForTeamB(score: Int) {
        val scoreView: TextView = findViewById(R.id.team_b_score)
        scoreView.text = "$score"
    }

    fun addOneForTeamA(view: View) {
        scoreTeamA += 1
        displayForTeamA(scoreTeamA)
    }

    fun addTwoForTeamA(view: View) {
        scoreTeamA += 2
        displayForTeamA(scoreTeamA)
    }

    fun addThreeForTeamA(view: View) {
        scoreTeamA += 3
        displayForTeamA(scoreTeamA)
    }

    fun addOneForTeamB(view: View) {
        scoreTeamB += 1
        displayForTeamB(scoreTeamB)
    }

    fun addTwoForTeamB(view: View) {
        scoreTeamB += 2
        displayForTeamB(scoreTeamB)
    }

    fun addThreeForTeamB(view: View) {
        scoreTeamB += 3
        displayForTeamB(scoreTeamB)
    }

    fun resetScore(view: View) {
        scoreTeamA = 0
        scoreTeamB = 0
        displayForTeamA(scoreTeamA)
        displayForTeamB(scoreTeamB)
    }
}