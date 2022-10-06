package com.example.homework17

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class LogInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        val intentNextActivity = Intent(this, SignUpActivity::class.java)
        val returnSignUp: TextView = findViewById(R.id.returnSignUp)

        returnSignUp.setOnClickListener {
            startActivity(intentNextActivity)
        }
    }
}