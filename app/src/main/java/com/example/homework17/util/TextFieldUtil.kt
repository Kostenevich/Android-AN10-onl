package com.example.homework17.util

import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.google.android.material.textfield.TextInputLayout

class TextFieldUtil: AppCompatActivity() {

    fun isFieldValid(fieldLayout: TextInputLayout, checker: Regex, errorMessage: Int): Boolean {
        val text = fieldLayout.editText?.text.toString()
        if (text.matches(checker) && text.isBlank().not()) {
            fieldLayout.error = null
            return true
        } else
            fieldLayout.error = getString(errorMessage)
        return false
    }

    fun isFieldBlank(fieldLayout: TextInputLayout, error: Int): Boolean {
        return if (fieldLayout.editText?.text.isNullOrBlank()) {
            fieldLayout.error = getString(error)
            false
        } else {
            fieldLayout.error = null
            true
        }
    }

     fun setListener(fieldLayout: TextInputLayout) {
        fieldLayout.editText?.addTextChangedListener {
            it.toString()
        }
    }
}