package com.asparrin.carlos.laboratoriocalificado01

//Importo la libreria test
import org.junit.Test

//Creo la clase Ejercicio01Kotlin
class Ejercicio01Kotlin {

    //Determino una prueba unitaria
    @Test
    //Creo la función testMaxOfThree
    fun testMaxOfThree() {
        //Imprimo los números ingresados
        println("Números ingresados: 5, 12, 3")
        // Imprimo un espacio en blanco
        println(" ")
        // Ingreso los números a comparar
        val result = maxNumber(5, 12, 3)
        // Imprimo el resultado
        println("El número mayor es: $result")
    }

    // Función que recibe tres enteros y devuelve el mayor de ellos
    private fun Ejercicio01Kotlin.maxNumber(a: Int, b: Int, c: Int): Int {
        // Comparo a y b, guarda en maxAB el mayor de ambos
        val maxAB = if (a >= b) a else b
        // Comparo maxAB con c, devuelvo el mayor entre esos dos
        return if (maxAB >= c) maxAB else c
    }
}