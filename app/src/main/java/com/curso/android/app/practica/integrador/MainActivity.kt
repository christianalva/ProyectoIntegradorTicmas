package com.curso.android.app.practica.integrador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {

    private val viewModel: Comparar by viewModels()

    private lateinit var boton : Button;
    private lateinit var primerTextoIntroducido : EditText;
    private lateinit var segundoTextoIntroducido : EditText;
    private lateinit var resultado : TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        primerTextoIntroducido = findViewById(R.id.primerTexto)
        segundoTextoIntroducido = findViewById(R.id.segundoTexto)
        resultado = findViewById(R.id.resultado)
        boton = findViewById(R.id.boton)

        boton.setOnClickListener {
            val text1 = primerTextoIntroducido.text.toString()
            val text2 = segundoTextoIntroducido.text.toString()

            viewModel.compararStrings(text1, text2)

        }

        viewModel.obtenerResultado().observe(this){result ->
            resultado.text= result

            // le cambio de color al texto segun sea lo que me salga
            if(result == "Ambas cadenas de caracteres son iguales."){
                resultado.setTextColor(ContextCompat.getColor(this, R.color.verde))
            } else if(result == "Las cadenas de caracteres son diferentes."){
                resultado.setTextColor(ContextCompat.getColor(this, R.color.red))
            } else {
                resultado.setTextColor(ContextCompat.getColor(this, R.color.amarillo))
            }
        }
    }


}