package com.example.meuprimeiroprojeto

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val edtPeso: EditText = findViewById(R.id.edittext_Peso)
        val edtaltura: EditText = findViewById(R.id.edittext_Altura)
        val btnCalcular: Button = findViewById(R.id.btnCalcular)


        btnCalcular.setOnClickListener {

            val alturaStr = edtaltura.text.toString()
            val pesoStr = edtPeso.text.toString()

            if (alturaStr.isNotEmpty() && pesoStr.isNotEmpty()) {
                val altura: Float = alturaStr.toFloat()
                val peso: Float = pesoStr.toFloat()

            val alturafinal: Float = altura * altura
            val result: Float = peso / alturafinal

            val intent = Intent( this, ResultActivity::class.java)
                .apply {
                   putExtra("EXTRA_RESULT", result)

                    }
                startActivity(intent)

            } else {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            }

        }
    }
}