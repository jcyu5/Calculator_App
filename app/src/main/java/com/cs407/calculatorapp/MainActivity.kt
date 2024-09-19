package com.cs407.calculatorapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editText1 = findViewById<EditText>(R.id.editText1)
        val editText2 = findViewById<EditText>(R.id.editText2)

        val additionButton = findViewById<Button>(R.id.additionButton)
        additionButton.setOnClickListener{
            try {
                val input1 = editText1.text.toString().toInt()
                val input2 = editText2.text.toString().toInt()
                val result = input1 + input2
                val intent = Intent(this, CalculatorActivity::class.java)
                intent.putExtra("RESULT", result.toString())
                startActivity(intent)
            } catch(e: NumberFormatException){
                val error = Toast.makeText(this, "Please Enter Valid Integers", Toast.LENGTH_SHORT)
                error.show()
            }
        }

        val subtractionButton = findViewById<Button>(R.id.subtractionButton)
        subtractionButton.setOnClickListener{
            try {
                val input1 = editText1.text.toString().toInt()
                val input2 = editText2.text.toString().toInt()
                val result = input1 - input2
                val intent = Intent(this, CalculatorActivity::class.java)
                intent.putExtra("RESULT", result.toString())
                startActivity(intent)
            } catch(e: NumberFormatException){
                val error = Toast.makeText(this, "Please Enter Valid Integers", Toast.LENGTH_SHORT)
                error.show()
            }
        }

        val multiplicationButton = findViewById<Button>(R.id.multiplicationButton)
        multiplicationButton.setOnClickListener{
            try {
                val input1 = editText1.text.toString().toInt()
                val input2 = editText2.text.toString().toInt()
                val result = input1 * input2
                val intent = Intent(this, CalculatorActivity::class.java)
                intent.putExtra("RESULT", result.toString())
                startActivity(intent)
            } catch(e: NumberFormatException){
                val error = Toast.makeText(this, "Please Enter Valid Integers", Toast.LENGTH_SHORT)
                error.show()
            }
        }

        val divisionButton= findViewById<Button>(R.id.divisionButton)
        divisionButton.setOnClickListener{
            try {
                val input1 = editText1.text.toString().toInt()
                val input2 = editText2.text.toString().toInt()
                val result = input1 / input2
                val intent = Intent(this, CalculatorActivity::class.java)
                intent.putExtra("RESULT", result.toString())
                startActivity(intent)
            } catch(e: NumberFormatException){
                val error = Toast.makeText(this, "Please Enter Valid Integers", Toast.LENGTH_SHORT)
                error.show()
            } catch(e: ArithmeticException){
                val error = Toast.makeText(this, "Error: $e", Toast.LENGTH_SHORT)
                error.show()
            }
        }
    }
}