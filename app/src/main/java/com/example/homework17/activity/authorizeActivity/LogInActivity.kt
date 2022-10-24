package com.example.homework17.activity.authorizeActivity

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.homework17.R
import com.example.homework17.activity.notesActivity.ListOfNotesActivity
import com.example.homework17.util.TextFieldUtil
import com.example.homework17.util.ToastUtil
import com.google.android.material.textfield.TextInputLayout

class LogInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        val toast = ToastUtil()
        val text = TextFieldUtil()

        val buttonLogIn: AppCompatButton = findViewById(R.id.buttonLogIn)

        val passwordFieldLayout: TextInputLayout = findViewById(R.id.passwordField)
        val emailFieldLayout: TextInputLayout = findViewById(R.id.emailField)

        val intentNoteList = Intent(this, ListOfNotesActivity::class.java)


        buttonLogIn.setOnClickListener {
            val isEmailValid = text.isFieldBlank(emailFieldLayout, R.string.error_blank)
            val isPasswordValid = text.isFieldBlank(passwordFieldLayout, R.string.error_blank)

            if (isEmailValid && isPasswordValid) {
                startActivity(intentNoteList)
            } else {
                toast.create(R.string.toast_error)
            }

        }
        val returnSignUp: TextView = findViewById(R.id.returnSignUp)
        val intentNextActivity = Intent(this, SignUpActivity::class.java)

        returnSignUp.setOnClickListener {
            startActivity(intentNextActivity)
        }
    }


}
