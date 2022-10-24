package com.example.homework17.recyclerView

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.homework17.R
import com.example.homework17.model.Note

class NoteViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    fun bind(note: Note) {
        view.apply {
            findViewById<TextView>(R.id.title).text = note.title
            findViewById<TextView>(R.id.message).text = note.message
            findViewById<TextView>(R.id.date).text = note.date.toString()
        }
    }
}