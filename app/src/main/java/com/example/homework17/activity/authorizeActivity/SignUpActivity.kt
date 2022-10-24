package com.example.homework17.activity.authorizeActivity

import android.content.Intent
import android.os.Bundle
import android.util.Patterns.EMAIL_ADDRESS
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.homework17.R
import com.example.homework17.activity.notesActivity.ListOfNotesActivity
import com.example.homework17.util.TextFieldUtil
import com.example.homework17.util.ToastUtil
import com.google.android.material.textfield.TextInputLayout

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        val toast = ToastUtil()
        val text = TextFieldUtil()

        val emailLayout: TextInputLayout = findViewById(R.id.emailFieldLayout)
        val firstNameLayout: TextInputLayout = findViewById(R.id.firstNameFieldLayout)
        val lastNameLayout: TextInputLayout = findViewById(R.id.lastNameFieldLayout)
        val passwordLayout: TextInputLayout = findViewById(R.id.passwordFieldLayout)
        val signUpButton: AppCompatButton = findViewById(R.id.buttonSignUp)

        val intentNoteList = Intent(this, ListOfNotesActivity::class.java)

        val logInChecker = "([A-Za-z0-9]).{2,255}".toRegex()
        val passwordChecker =
            "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@\$%^&*-]).{6,50}\$".toRegex()
        val emailChecker = EMAIL_ADDRESS.toRegex()

        text.setListener(firstNameLayout)
        text.setListener(lastNameLayout)
        text.setListener(passwordLayout)
        text.setListener(emailLayout)

        signUpButton.setOnClickListener {
            val isFirstNameValid =
                text.isFieldValid(firstNameLayout, logInChecker, R.string.name_error)
            val isLastNameValid =
                text.isFieldValid(lastNameLayout, logInChecker, R.string.surname_error)
            val isEmailValid = text.isFieldValid(emailLayout, emailChecker, R.string.email_error)
            val isPasswordValid =
                text.isFieldValid(passwordLayout, passwordChecker, R.string.password_error)

            if (isFirstNameValid && isLastNameValid && isEmailValid && isPasswordValid) {
                startActivity(intentNoteList)
            } else {
                toast.create(R.string.toast_error)
            }
        }

        val intentNextActivity = Intent(this, LogInActivity::class.java)
        val logInText: TextView = findViewById(R.id.logInText)

        logInText.setOnClickListener {
            startActivity(intentNextActivity)
        }
    }
}

