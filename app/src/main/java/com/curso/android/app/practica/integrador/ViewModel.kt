package com.curso.android.app.practica.integrador

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Comparar : ViewModel() {

    // Creo un LiveData mutable para almacenar el resultado de la comparación, y le decimos que vamos a guardar un string
    private val resultadoDeComparar =   MutableLiveData<String>()

    fun obtenerResultado(): LiveData<String> {
        return resultadoDeComparar
    }

    fun compararStrings(str1 : String, str2:String){
        if(str1 == "" || str2 == ""){
            resultadoDeComparar.value =  "Se deben introducir dos cadenas de caracteres."
        } else if (str1 == str2){
            resultadoDeComparar.value = "Ambas cadenas de caracteres son iguales."
        } else{
            resultadoDeComparar.value = "Las cadenas de caracteres son diferentes."
        }
    }

}