package vcmsa.jadenenaidoo.flashcardapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
Log.d("MainActivity", "App started-Welcome screen loaded")

        // Set up button click listener
        val btnStart = findViewById<Button>(R.id.btnStart)
         btnStart.setOnClickListener {
             Log.d("MainActivity", "Start button clicked")
            val intent = Intent(this, FlashcardQuestionActivity::class.java)
            startActivity(intent)
        }
    }
}
