package com.example.homework17

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.google.android.material.textfield.TextInputEditText

class AddNotesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_notes)

        val buttonAdd = findViewById<AppCompatButton>(R.id.buttonAdd)
        val buttonBack = findViewById<TextView>(R.id.back)
        val intentAdd = Intent(this, ListOfNotesActivity::class.java)

        val title = findViewById<TextInputEditText>(R.id.titleEditText)
        val message = findViewById<TextInputEditText>(R.id.messageEditText)

        buttonAdd.setOnClickListener {
            intentAdd.putExtra("title", title?.text.toString())
            intentAdd.putExtra("message", message.text?.toString())
            startActivity(intentAdd)
        }
        buttonBack.setOnClickListener {
            startActivity(intentAdd)
        }
    }
}