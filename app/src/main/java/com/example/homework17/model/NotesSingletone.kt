package com.example.homework17.model

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime

class NotesSingleton {

    object NotesSingleton {
        @RequiresApi(Build.VERSION_CODES.O)
        var listOfNotes: ArrayList<Note> = arrayListOf(
            Note("test1", "message testing", LocalDateTime.now()),
            Note("test2", "message testing", LocalDateTime.now()),
            Note("test3", "message testing", LocalDateTime.now()),
            Note("test4", "message testing", LocalDateTime.now()),
            Note("test5", "message testing", LocalDateTime.now()),
        )

    }


}