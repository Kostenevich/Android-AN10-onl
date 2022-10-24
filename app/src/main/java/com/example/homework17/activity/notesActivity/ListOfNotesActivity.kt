package com.example.homework17.activity.notesActivity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homework17.R
import com.example.homework17.activity.authorizeActivity.SignUpActivity
import com.example.homework17.model.NotesSingleton.NotesSingleton.listOfNotes
import com.example.homework17.recyclerView.NoteRecyclerAdapter

class ListOfNotesActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_of_notes)

        val logOutButton = findViewById<TextView>(R.id.logOut)
        val addNewButton = findViewById<TextView>(R.id.AddNote)

        val intentLogOut = Intent(this, SignUpActivity::class.java)
        val intentAddNew = Intent(this, AddNotesActivity::class.java)


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