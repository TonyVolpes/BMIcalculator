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

        // Collegamento delle variabili di istanza alle viste nel layout
        editHeight = findViewById(R.id.editHeight)
        editWeight = findViewById(R.id.editWeight)
        btnCalculate = findViewById(R.id.btnCalculate)
        textResult = findViewById(R.id.textResult)

        // Impostazione di un listener per il pulsante di calcolo
        btnCalculate.setOnClickListener {
            calculateBMI()
        }
    }

    private fun calculateBMI() {
        // Recupero dei valori di altezza e peso inseriti dall'utente
        val height = editHeight.text.toString().toFloatOrNull()
        val weight = editWeight.text.toString().toFloatOrNull()

        // Controllo se gli input sono validi
        if (height != null && weight != null) {
            // Calcolo del BMI utilizzando la formula peso / (altezza^2)
            val bmi = weight / height.pow(2)

            // Determinazione della condizione corrispondente al valore del BMI
            val resultText = when {
                bmi < 18.5 -> "Sottopeso"
                bmi < 25 -> "Normale"
                bmi < 30 -> "Sovrappeso"
                else -> "Obeso"
            }

            // Impostazione del risultato nella vista textResult utilizzando la risorsa di stringa bmi_result
            textResult.setText(getString(R.string.bmi_result, bmi, resultText))
        } else {
            // Visualizzazione di un messaggio di errore se gli input non sono validi
            textResult.text = "Inserisci valori validi per altezza e peso."
        }
    }
}

