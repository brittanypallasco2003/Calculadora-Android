package com.example.calculador3

import android.os.Bundle
import androidx.activity.ComponentActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.tan

class MainActivity : ComponentActivity() {
    private lateinit var display: EditText
    private var currentNumber: String = ""
    private var operator: String? = null
    private var firstNumber: Double? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        display = findViewById(R.id.display)

        // Configurar los botones
        findViewById<Button>(R.id.button0).setOnClickListener { onNumberClick(it) }
        findViewById<Button>(R.id.button1).setOnClickListener { onNumberClick(it) }
        findViewById<Button>(R.id.button2).setOnClickListener { onNumberClick(it) }
        findViewById<Button>(R.id.button3).setOnClickListener { onNumberClick(it) }
        findViewById<Button>(R.id.button4).setOnClickListener { onNumberClick(it) }
        findViewById<Button>(R.id.button5).setOnClickListener { onNumberClick(it) }
        findViewById<Button>(R.id.button6).setOnClickListener { onNumberClick(it) }
        findViewById<Button>(R.id.button7).setOnClickListener { onNumberClick(it) }
        findViewById<Button>(R.id.button8).setOnClickListener { onNumberClick(it) }
        findViewById<Button>(R.id.button9).setOnClickListener { onNumberClick(it) }
        findViewById<Button>(R.id.buttonDot).setOnClickListener { onNumberClick(it) }
        findViewById<Button>(R.id.buttonAdd).setOnClickListener { onOperatorClick(it) }
        findViewById<Button>(R.id.buttonSubtract).setOnClickListener { onOperatorClick(it) }
        findViewById<Button>(R.id.buttonMultiply).setOnClickListener { onOperatorClick(it) }
        findViewById<Button>(R.id.buttonDivide).setOnClickListener { onOperatorClick(it) }
        findViewById<Button>(R.id.buttonEquals).setOnClickListener { onEqualsClick(it) }
        findViewById<Button>(R.id.buttonClear).setOnClickListener { onClearClick(it) }
        findViewById<Button>(R.id.buttonSin).setOnClickListener { onTrigClick(it) }
        findViewById<Button>(R.id.buttonCos).setOnClickListener { onTrigClick(it) }
        findViewById<Button>(R.id.buttonTan).setOnClickListener { onTrigClick(it) }
    }

    private fun onNumberClick(view: View) {
        val button = view as Button
        currentNumber += button.text
        display.setText(currentNumber)
    }

    private fun onOperatorClick(view: View) {
        val button = view as Button
        operator = button.text.toString()
        firstNumber = currentNumber.toDoubleOrNull()
        currentNumber = ""
        display.setText("")
    }

    private fun onEqualsClick(view: View) {
        val secondNumber = currentNumber.toDoubleOrNull()
        if (firstNumber != null && secondNumber != null) {
            val result = when (operator) {
                "+" -> firstNumber!! + secondNumber
                "-" -> firstNumber!! - secondNumber
                "*" -> firstNumber!! * secondNumber
                "/" -> firstNumber!! / secondNumber
                else -> 0.0
            }
            display.setText(result.toString())
            currentNumber = result.toString()
            operator = null
            firstNumber = null
        }
    }

    private fun onTrigClick(view: View) {
        val button = view as Button
        val angle = currentNumber.toDoubleOrNull()
        if (angle != null) {
            val result = when (button.text.toString()) {
                "sin" -> sin(Math.toRadians(angle))
                "cos" -> cos(Math.toRadians(angle))
                "tan" -> tan(Math.toRadians(angle))
                else -> 0.0
            }
            display.setText(result.toString())
            currentNumber = result.toString()
        }
    }

    private fun onClearClick(view: View) {
        currentNumber = ""
        operator = null
        firstNumber = null
        display.setText("")
    }
}