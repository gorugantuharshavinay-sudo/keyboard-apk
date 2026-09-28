package com.example.telugukeyboard

import android.inputmethodservice.InputMethodService
import android.inputmethodservice.Keyboard
import android.inputmethodservice.KeyboardView
import android.view.View

class TeluguKeyboardService : InputMethodService(), KeyboardView.OnKeyboardActionListener {
    private lateinit var view: KeyboardView

    override fun onCreateInputView(): View {
        view = layoutInflater.inflate(R.layout.keyboard_view, null) as KeyboardView
        view.keyboard = Keyboard(this, R.xml/telugu_keys)
        view.setOnKeyboardActionListener(this)
        return view
    }

    override fun onKey(primaryCode: Int, keyCodes: IntArray?) {
        val connection = currentInputConnection ?: return
        when (primaryCode) {
            Keyboard.KEYCODE_DELETE -> connection.deleteSurroundingText(1, 0)
            Keyboard.KEYCODE_DONE -> connection.sendKeyEvent(android.view.KeyEvent(android.view.KeyEvent.ACTION_DOWN, android.view.KeyEvent.KEYCODE_ENTER))
            else -> connection.commitText(String(Character.toChars(primaryCode)), 1)
        }
    }

    override fun onText(text: CharSequence?) { if (text != null) currentInputConnection?.commitText(text, 1) }
    override fun swipeLeft() {}
    override fun swipeRight() {}
    override fun swipeUp() {}
    override fun swipeDown() {}
    override fun onPress(primaryCode: Int) {}
    override fun onRelease(primaryCode: Int) {}
}
