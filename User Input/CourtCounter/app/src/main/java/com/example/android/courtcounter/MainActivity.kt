package com.example.android.courtcounter

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var scoreTeamA: Int = 0

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

    fun addOnePoint(view: View) {
        scoreTeamA += 1
        displayForTeamA(scoreTeamA)
    }

    fun addTwoPoints(view: View) {
        scoreTeamA += 2
        displayForTeamA(scoreTeamA)
    }

    fun addThreePoints(view: View) {
        scoreTeamA += 3
        displayForTeamA(scoreTeamA)
    }
}