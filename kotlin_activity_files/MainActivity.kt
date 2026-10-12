package com.example.test_app
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent

class MainActivity : AppCompatActivity() {
    private var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val countText = findViewById<TextView>(R.id.textView2)
        val clickButton = findViewById<Button>(R.id.button)
        val resetButton = findViewById<Button>(R.id.button2)
        val fuelappbutton = findViewById<Button>(R.id.button3)

        countText.text = counter.toString()

        clickButton.setOnClickListener {
            counter++
            countText.text = counter.toString()
        }
        resetButton.setOnClickListener {
            counter = 0
            countText.text = counter.toString()
        }
        fuelappbutton.setOnClickListener {
            val intent = Intent(this, fuelest::class.java)
            startActivity(intent)
        }
    }
}