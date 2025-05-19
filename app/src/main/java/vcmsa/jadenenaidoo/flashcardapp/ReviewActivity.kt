package vcmsa.jadenenaidoo.flashcardapp

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.util.Log

// ReviewActivity.kt
class ReviewActivity : AppCompatActivity() {
    private val questions = arrayOf(
        "Nelson Mandela was the president in 1994",
        "Johannesburg is one of South Africa's capitals",
        "Cape of Good Hope is Africa's southernmost point",
        "Cape Town is the oldest city in South Africa",
        "Elon Musk has lived most of his life in South Africa",

    )

    //array of answers
    private val answers = arrayOf(true, false, true, false, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val layout = LinearLayout(this)
        Log.d("ReviewActivity", "Review screen started")
        layout.orientation = LinearLayout.VERTICAL

        // Display the questions and answers
        for (i in questions.indices) {
            val textView = TextView(this)
            textView.text = "Q: ${questions[i]}\nA: ${if (answers[i]) "True" else "False"}"
            textView.textSize = 18f
            layout.addView(textView)
            Log.d("ReviewActivity", "Question displayed: ${questions[i]}")
        }

        // Set the layout as the content view
        setContentView(layout)
    }
}