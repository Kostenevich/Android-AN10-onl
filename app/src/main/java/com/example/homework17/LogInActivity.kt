package com.example.homework17

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.google.android.material.textfield.TextInputLayout

class LogInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        val buttonLogIn: AppCompatButton = findViewById(R.id.buttonLogIn)

        val passwordFieldLayout: TextInputLayout = findViewById(R.id.passwordField)
        val emailFieldLayout: TextInputLayout = findViewById(R.id.emailField)

        val intentNoteList = Intent(this, ListOfNotesActivity::class.java)


        buttonLogIn.setOnClickListener {
            val isEmailValid = checker(emailFieldLayout, R.string.error_blank)
            val isPasswordValid = checker(passwordFieldLayout, R.string.error_blank)

            if (isEmailValid && isPasswordValid) {
                startActivity(intentNoteList)
            } else {
                toast(R.string.toast_error)
            }

        }
        val returnSignUp: TextView = findViewById(R.id.returnSignUp)
        val intentNextActivity = Intent(this, SignUpActivity::class.java)

        returnSignUp.setOnClickListener {
            startActivity(intentNextActivity)
        }
    }

    private fun checker(fieldLayout: TextInputLayout, error: Int): Boolean {
        return if (fieldLayout.editText?.text.isNullOrBlank()) {
            fieldLayout.error = getString(error)
            false
        } else {
            fieldLayout.error = null
            true
        }
    }

    private fun toast(toastMessage: Int) {
        val toastText = getString(toastMessage)
        val toast = Toast.makeText(applicationContext, toastText, toastText.length)
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.show()
    }
}
