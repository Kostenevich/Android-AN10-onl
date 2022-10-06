package com.example.homework17

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton

val handler = Handler(Looper.getMainLooper())

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intentDiscoverActivity = Intent(this, FirstDiscoverActivity::class.java)
        val intentLogInActivity = Intent(this, LogInActivity::class.java)

        val buttonDiscover: AppCompatButton = findViewById(R.id.buttonDiscover)
        val buttonLogInText: TextView = findViewById(R.id.logInText)

        buttonDiscover.setOnClickListener {
            startActivity(intentDiscoverActivity)
        }

        buttonLogInText.setOnClickListener {
            startActivity(intentLogInActivity)
        }

    }
}