package com.example.homework17

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import androidx.core.os.postDelayed

class FirstDiscoverActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_discover)

        val intentNextActivity = Intent(this, SecondDiscoverActivity::class.java)
        val buttonSkip: TextView = findViewById(R.id.skip)

        handler.postDelayed(10000) {
            startActivity(intentNextActivity)
        }

        buttonSkip.setOnClickListener {
            startActivity(intentNextActivity)
            handler.removeCallbacksAndMessages(null)
        }

    }
}
