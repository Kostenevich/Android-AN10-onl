package com.example.homework17.model

import java.time.LocalDateTime

data class Note(
    var title: String?,
    val message: String?,
    val date: LocalDateTime
)
