package com.example.homework17

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homework17.NotesSingleton.listOfNotes
import java.time.LocalDateTime

class ListOfNotesActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_of_notes)

        val logOutButton = findViewById<TextView>(R.id.logOut)
        val addNewButton = findViewById<TextView>(R.id.AddNote)

        val intentLogOut = Intent(this, SignUpActivity::class.java)
        val intentAddNew = Intent(this, AddNotesActivity::class.java)


        val noteTitle = intent.getStringExtra("title")
        val noteMessage = intent.getStringExtra("message")
        val noteDate = LocalDateTime.now()
        val note = Note(noteTitle, noteMessage, noteDate)
        listOfNotes.add(note)



        findViewById<RecyclerView>(R.id.recyclerNotes).run {
            if (adapter == null) {
                adapter = NoteRecyclerAdapter()
                layoutManager = LinearLayoutManager(this@ListOfNotesActivity)
            }
            (adapter as NoteRecyclerAdapter).setList(listOfNotes)
        }

        logOutButton.setOnClickListener {
            startActivity(intentLogOut)
        }

        addNewButton.setOnClickListener {
            startActivity(intentAddNew)
        }
    }
}