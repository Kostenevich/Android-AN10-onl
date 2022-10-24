package com.example.homework17.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework17.R
import com.example.homework17.model.Note

class NoteRecyclerAdapter : RecyclerView.Adapter<NoteViewHolder>() {
    private var list = arrayListOf<Note>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    fun setList(list: ArrayList<Note>) {
        this.list = list
        notifyDataSetChanged()
    }
}