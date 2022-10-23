package com.example.homework17

import android.content.Intent
import android.os.Bundle
import android.util.Patterns.EMAIL_ADDRESS
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.widget.addTextChangedListener
import com.google.android.material.textfield.TextInputLayout

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

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

        textListener(firstNameLayout)
        textListener(lastNameLayout)
        textListener(passwordLayout)
        textListener(emailLayout)

        signUpButton.setOnClickListener {
            val isFirstNameValid = validation(firstNameLayout, logInChecker, R.string.name_error)
            val isLastNameValid = validation(lastNameLayout, logInChecker, R.string.surname_error)
            val isEmailValid = validation(emailLayout, emailChecker, R.string.email_error)
            val isPasswordValid =
                validation(passwordLayout, passwordChecker, R.string.password_error)

            if (isFirstNameValid && isLastNameValid && isEmailValid && isPasswordValid) {
                startActivity(intentNoteList)
            } else {
                toast(R.string.toast_error)
            }
        }

        val intentNextActivity = Intent(this, LogInActivity::class.java)
        val logInText: TextView = findViewById(R.id.logInText)

        logInText.setOnClickListener {
            startActivity(intentNextActivity)
        }
    }

    private fun textListener(fieldLayout: TextInputLayout) {
        fieldLayout.editText?.addTextChangedListener {
            it.toString()
        }
    }

    private fun toast(toastMessage: Int) {
        val toastText = getString(toastMessage)
        val toast = Toast.makeText(applicationContext, toastText, toastText.length)
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.show()
    }

    private fun validation(
        fieldLayout: TextInputLayout, checker: Regex, errorMessage: Int
    ): Boolean {
        val text = fieldLayout.editText?.text.toString()
        if (text.matches(checker) && text.isBlank().not()) {
            fieldLayout.error = null
            return true
        } else
            fieldLayout.error = getString(errorMessage)
        return false
    }
}

