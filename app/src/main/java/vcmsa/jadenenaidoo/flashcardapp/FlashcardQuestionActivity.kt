package vcmsa.jadenenaidoo.flashcardapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.util.Log

// MainActivity.kt
//display array of questions and answers
class FlashcardQuestionActivity : AppCompatActivity() {
    private val questions = arrayOf(
        "Nelson Mandela was the president in 1994",
        "Johannesburg is one of South Africa's capitals",
        "Cape of Good Hope is Africa's southernmost point",
        "Cape Town is the oldest city in South Africa",
        "Elon Musk has lived most of his life in South Africa",
    )
//array of answers
    private val answers = arrayOf(true, false, true, false, false)

    private var currentQuestionIndex = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flashcard_question)
Log.d("FlashcardActivity", "Quiz screen started")

        // Initialize UI elements
        val questionText = findViewById<TextView>(R.id.textQuestion)
        val feedbackText = findViewById<TextView>(R.id.textFeedback)
        val trueButton = findViewById<Button>(R.id.btnTrue)
        val falseButton = findViewById<Button>(R.id.btnFalse)
        val nextButton = findViewById<Button>(R.id.btnNext)

        // Load the first question
        fun loadQuestion() {
            questionText.text = questions[currentQuestionIndex]
            feedbackText.text = ""
            Log.d("FlashcardActivity", "Question loaded: ${questions[currentQuestionIndex]}")
        }

        // Load the first question
        loadQuestion()

        trueButton.setOnClickListener {
            Log.d("FlashcardActivity", "True button clicked")
            checkAnswer(true, feedbackText)
        }

        falseButton.setOnClickListener {
            Log.d("FlashcardActivity", "False button clicked")
            checkAnswer(false, feedbackText)
        }

        // Load the next question
        nextButton.setOnClickListener {
            currentQuestionIndex++
            if (currentQuestionIndex < questions.size) {
            Log.d("FlashcardActivity", "Next button clicked")
                loadQuestion()
            } else {
                Log.d("FlashcardActivity", "All questions answered")
                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("SCORE", score)
                startActivity(intent)
                finish()
            }
        }
    }

    // Check the user's answer and update the feedback
    private fun checkAnswer(userAnswer: Boolean, feedbackText: TextView) {
        val correct = answers[currentQuestionIndex] == userAnswer
        if (correct) {
            score++
            feedbackText.text = "Correct!"
            Log.d("FlashcardActivity", "Correct answer")
        } else {
            feedbackText.text = "Incorrect!"
            Log.d("FlashcardActivity", "Incorrect answer")
        }
    }
}