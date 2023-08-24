package com.curso.android.app.practica.integrador

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

//TEXT UI


class MainActivityUITest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testCompararButtonClick() {
        val str1 = "Hola"
        val str2 = "Hola"

        onView(withId(R.id.primerTexto)).perform(typeText(str1))
        onView(withId(R.id.segundoTexto)).perform(typeText(str2))

        onView(withId(R.id.boton)).perform(click())

        onView(withId(R.id.resultado)).check(matches(withText("Ambas cadenas de caracteres son iguales.")))
    }

    @Test
    fun testCompararButtonEmptyStrings() {
        val str1 = ""
        val str2 = ""

        onView(withId(R.id.primerTexto)).perform(typeText(str1))
        onView(withId(R.id.segundoTexto)).perform(typeText(str2))

        onView(withId(R.id.boton)).perform(click())

        onView(withId(R.id.resultado)).check(matches(withText("Se deben introducir dos cadenas de caracteres.")))
    }
}
