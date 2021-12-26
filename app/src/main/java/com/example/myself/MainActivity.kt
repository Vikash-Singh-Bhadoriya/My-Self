package com.example.myself

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var previousValues = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        create_button.setOnClickListener {
            val imm =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(it.windowToken, 0)

            val currentValues = mutableListOf(
                first_name_edit_text.text.toString(),
                last_name_edit_text.text.toString(),
                standard_class_edit_text.text.toString(),
                sec_edit_text.text.toString(),
                school_name_edit_text.text.toString()
            )
            if (currentValues[0].isBlank() || currentValues[1].isBlank() || currentValues[2].isBlank() || currentValues[3].isBlank() || currentValues[4].isBlank()) {
                introduction_text_view.text = getString(R.string.mandatory_field_msg)
                return@setOnClickListener
            } else if (currentValues == previousValues) {
                introduction_text_view.text = getString(R.string.update_fields_msg)
                return@setOnClickListener
            }
            previousValues = currentValues
            introduction_text_view.text = getString(
                R.string.my_self_description,
                currentValues[0],
                currentValues[1],
                currentValues[2],
                currentValues[3],
                currentValues[4]
            )
        }
    }
}