package com.example.homework17

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.postDelayed

class FourthDiscoverActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth_discover)

        val intentNextActivity = Intent(this, FifthDiscoverActivity::class.java)
        val buttonSkip: TextView = findViewById(R.id.skip)

        handler.postDelayed(10000) {
            startActivity(intentNextActivity)
            finish()
        }

        buttonSkip.setOnClickListener {
            startActivity(intentNextActivity)
            handler.removeCallbacksAndMessages(null)
        }
    }
}