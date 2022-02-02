package com.example.whogoesfirst

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    // create variables to work with views
    private lateinit var selectTeamButton: Button
    private lateinit var enterTeamName1: EditText
    private lateinit var enterTeamName2: EditText
    private lateinit var resultsShownHereText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // set up reference to view / content item so the code knows what to work with
        selectTeamButton = findViewById(R.id.select_team_button)
        enterTeamName1 = findViewById(R.id.enter_team_name_1)
        enterTeamName2 = findViewById(R.id.enter_team_name_2)

        // this is where the results are shown
        resultsShownHereText = findViewById(R.id.results_shown_here_text)


        selectTeamButton.setOnClickListener {
            val teamText1 = enterTeamName1.text
            val teamText2 = enterTeamName2.text
            // when button is clicked, read both team names from EditText widgets
            // check use has typed something into both EditText widgets
            // if not, use a Toast to remind them to fill in both
            if (teamText1.isBlank() || teamText2.isBlank()) {
                Toast.makeText(this, getString(R.string.team_name_blank_error), Toast.LENGTH_LONG).show()
            } else {
                // create list of team choices to pull from, use random() to pick one
                val teamChoice = listOf("team1", "team2").random()
                if (teamChoice == "team1") {
                    resultsShownHereText.text = teamText1
                } else {
                    resultsShownHereText.text = teamText2
                }
            }

        }

    }
}