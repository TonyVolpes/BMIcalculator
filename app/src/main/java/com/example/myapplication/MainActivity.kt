package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    private lateinit var editHeight: EditText
    private lateinit var editWeight: EditText
    private lateinit var btnCalculate: Button
    private lateinit var textResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      
        editHeight = findViewById(R.id.editHeight)
        editWeight = findViewById(R.id.editWeight)
        btnCalculate = findViewById(R.id.btnCalculate)
        textResult = findViewById(R.id.textResult)

     
        btnCalculate.setOnClickListener {
            calculateBMI()
        }
    }

    private fun calculateBMI() {
       
        val height = editHeight.text.toString().toFloatOrNull()
        val weight = editWeight.text.toString().toFloatOrNull()

        
        if (height != null && weight != null) {
       
            val bmi = weight / height.pow(2)

            
            val resultText = when {
                bmi < 18.5 -> "Sottopeso"
                bmi < 25 -> "Normale"
                bmi < 30 -> "Sovrappeso"
                else -> "Obeso"
            }

         
            textResult.setText(getString(R.string.bmi_result, bmi, resultText))
        } else {
     
            textResult.text = "Inserisci valori validi per altezza e peso."
        }
    }
}

