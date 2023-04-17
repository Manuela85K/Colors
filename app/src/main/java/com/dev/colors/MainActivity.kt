package com.dev.colors

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    lateinit var etRed : TextInputEditText
    lateinit var etGreen : TextInputEditText
    lateinit var etBlue : TextInputEditText
    lateinit var btnCreate : MaterialButton
    lateinit var viewOutPut : AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etRed = findViewById(R.id.etRed)
        etGreen = findViewById(R.id.etGreen)
        etBlue = findViewById(R.id.etBlue)
        btnCreate = findViewById(R.id.btnCreate)
        viewOutPut = findViewById(R.id.viewOutPut)

        val allowedCharsPattern = Regex("[0-9A-Fa-f]+")
        val inputFilter = InputFilter { source, start, end, dest, dstart, dend ->
            if (source.toString().matches(allowedCharsPattern)) {
                source
            } else {
                ""
            }
        }

        etBlue.filters = arrayOf(inputFilter)
        etGreen.filters = arrayOf(inputFilter)
        etRed.filters = arrayOf(inputFilter)

        btnCreate.setOnClickListener {
            val redInput = etRed.text.toString()
            val greenInput = etGreen.text.toString()
            val blueInput = etRed.text.toString()
            if (!redInput.isEmpty() && !greenInput.isEmpty() && !blueInput.isEmpty()) {
                val colorCode = "#$redInput$greenInput$blueInput"
                val rgbColor = Color.parseColor(colorCode)
                viewOutPut.visibility = View.VISIBLE
                viewOutPut.setBackgroundColor(rgbColor)

            }
        }
    }
}