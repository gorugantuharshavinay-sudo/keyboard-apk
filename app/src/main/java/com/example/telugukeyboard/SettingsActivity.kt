package com.example.telugukeyboard

import android.app.Activity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.content.Context
import android.widget.Button

class SettingsActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val button = Button(this).apply { text = "Enable Telugu Keyboard"; setOnClickListener {
            (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).showInputMethodPicker()
        } }
        setContentView(button)
    }
}
