package com.example.homework17.activity.discoverActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.os.postDelayed
import com.example.homework17.R
import com.example.homework17.handler

class ThirdDiscoverActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_discover)

        val intentNextActivity = Intent(this, FourthDiscoverActivity::class.java)
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