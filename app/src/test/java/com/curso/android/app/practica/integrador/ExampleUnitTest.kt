package com.curso.android.app.practica.integrador

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations


//TEXT UNITARIO

class CompararViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var observer: Observer<String>

    private lateinit var viewModel: Comparar

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        viewModel = Comparar()
    }

    @Test
    fun testCompararStringsVacias() {
        val str1 = ""
        val str2 = ""

        viewModel.obtenerResultado().observeForever(observer)
        viewModel.compararStrings(str1, str2)

        verify(observer).onChanged("Se deben introducir dos cadenas de caracteres.")
    }

    @Test
    fun testCompararStringsIguales() {
        val str1 = "Hola"
        val str2 = "Hola"

        viewModel.obtenerResultado().observeForever(observer)
        viewModel.compararStrings(str1, str2)

        verify(observer).onChanged("Ambas cadenas de caracteres son iguales.")
    }

    @Test
    fun testCompararStringsDiferentes() {
        val str1 = "Hola"
        val str2 = "Chau"

        viewModel.obtenerResultado().observeForever(observer)
        viewModel.compararStrings(str1, str2)

        verify(observer).onChanged("Las cadenas de caracteres son diferentes.")
    }
}
