package com.example.test_app

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import android.content.Intent
import java.util.Locale

class fuelest : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fuelest)

        val distance = findViewById<EditText>(R.id.textdist)
        val fuel_effi = findViewById<EditText>(R.id.txtfe)
        val fuel_pri = findViewById<EditText>(R.id.txtfp)
        val calculate = findViewById<Button>(R.id.btncal)
        val result = findViewById<TextView>(R.id.txtres)
        val counter = findViewById<Button>(R.id.btncntr)

        calculate.setOnClickListener {
            val dist = distance.text.toString().toDoubleOrNull()
            val effi = fuel_effi.text.toString().toDoubleOrNull()
            val pri = fuel_pri.text.toString().toDoubleOrNull()

            if (dist == null || effi == null || pri == null ||
                dist == 0.0 || effi == 0.0 || pri == 0.0) {
                Toast.makeText(
                    this,
                    "Please enter valid number in all fields",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            val fuelUsed = dist / effi
            val price = fuelUsed * pri

            result.text = String.format(Locale.getDefault(), "%.2f INR", price)

        counter.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        }
    }
}