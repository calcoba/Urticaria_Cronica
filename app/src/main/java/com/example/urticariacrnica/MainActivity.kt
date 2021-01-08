package com.example.urticariacrnica

import android.Manifest
import android.Manifest.permission
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonUAS7 = findViewById<Button>(R.id.button)
        buttonUAS7.setOnClickListener {
            val intent = Intent(this, UAS7_scale::class.java)
            startActivity(intent)
        }

        val buttonUCT = findViewById<Button>(R.id.button3)
        buttonUCT.setOnClickListener {
            val intent = Intent(this, UCT_scale::class.java)
            startActivity(intent)
        }

        val buttonscores = findViewById<Button>(R.id.button5)
        buttonscores.setOnClickListener {
            val intent = Intent(this, Results::class.java)
            startActivity(intent)
        }
    }
}
