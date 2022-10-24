package com.example.homework17.util

import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

 class ToastUtil : AppCompatActivity() {

    fun create(toastMessage: Int) {
        val toastText = getString(toastMessage)
        val toast = Toast.makeText(applicationContext, toastText, toastText.length)
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.show()
    }
}