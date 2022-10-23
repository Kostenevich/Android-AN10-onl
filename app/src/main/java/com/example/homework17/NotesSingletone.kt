package com.example.homework17

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime

object NotesSingleton {
    @RequiresApi(Build.VERSION_CODES.O)
    val listOfNotes = arrayListOf(
        Note("test1", "message testing", LocalDateTime.now()),
        Note("test2", "message testing", LocalDateTime.now()),
        Note("test3", "message testing", LocalDateTime.now()),
        Note("test4", "message testing", LocalDateTime.now()),
        Note("test5", "message testing", LocalDateTime.now()),
    )
}