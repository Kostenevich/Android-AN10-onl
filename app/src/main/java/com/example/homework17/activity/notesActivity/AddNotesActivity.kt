package com.example.homework17.activity.notesActivity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.homework17.R
import com.example.homework17.model.Note
import com.example.homework17.model.NotesSingleton
import com.google.android.material.textfield.TextInputEditText
import java.time.LocalDateTime

class AddNotesActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_notes)

        val buttonAdd = findViewById<AppCompatButton>(R.id.buttonAdd)
        val buttonBack = findViewById<TextView>(R.id.back)
        val intentAdd = Intent(this, ListOfNotesActivity::class.java)

        val title = findViewById<TextInputEditText>(R.id.titleEditText)
        val message = findViewById<TextInputEditText>(R.id.messageEditText)

        buttonAdd.setOnClickListener {
            val noteTitle = title.text?.toString()
            val noteMessage = message.text?.toString()
            val noteDate = LocalDateTime.now()
            val note = Note(noteTitle, noteMessage, noteDate)
            NotesSingleton.NotesSingleton.listOfNotes.add(note)
            startActivity(intentAdd)
        }
        buttonBack.setOnClickListener {
            startActivity(intentAdd)
        }
    }
}