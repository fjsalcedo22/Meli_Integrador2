package com.example.meli_integrador2.utils

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import com.example.meli_integrador2.R

class TextChangedListener(private val button: Button, private val editText: EditText,private val context: Context) : TextWatcher {

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        // Nothing
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        s?.let {
            when{
                it.toString() == "0" ->  editText.error = context.getString(R.string.please_enter_number_other_than_0)
                it.isNotEmpty() -> button.isEnabled = true
                it.isEmpty() -> button.isEnabled = false
            }
        } ?: kotlin.run { button.isEnabled = false }
    }

    override fun afterTextChanged(s: Editable?) {
          // Nothing
    }
}