package vcmsa.jadenenaidoo.flashcardapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.util.Log

class ScoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        // Retrieve the score from the intent
        val score = intent.getIntExtra("SCORE", 0)
        Log.d("ScoreActivity", "Score: $score")
        val scoreText = findViewById<TextView>(R.id.textScore)
        val feedbackText = findViewById<TextView>(R.id.textFeedback)
        val reviewButton = findViewById<Button>(R.id.btnReview)
        val exitButton = findViewById<Button>(R.id.btnExitApp)

        /// Display the score and feedback
        scoreText.text = "Your Score: $score / 5"

        feedbackText.text = when {
            score >= 4 -> "Great job!"
            score >= 2 -> "Good try! Keep practicing."
            else -> "You can do better! Try again."
        }

        // Set up button click listeners
        reviewButton.setOnClickListener {
            Log.d("ScoreActivity", "Review button clicked")
            val intent = Intent(this, ReviewActivity::class.java)
            startActivity(intent)
        }

        // Exit the app
        exitButton.setOnClickListener {
            Log.d("ScoreActivity", "Exit button clicked")
            finishAffinity()
        }
    }
}