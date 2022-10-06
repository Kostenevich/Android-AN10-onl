package com.example.homework17

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import androidx.core.os.postDelayed

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val intentNextActivity = Intent (this, LogInActivity::class.java)
        val logInText : TextView = findViewById(R.id.logInText)

        logInText.setOnClickListener {
            startActivity(intentNextActivity)
        }
    }
}
