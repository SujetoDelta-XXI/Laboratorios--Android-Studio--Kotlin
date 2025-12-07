package com.asparrin.carlos.laboratoriocalificado01
import org.junit.Test

class Ejercicio02Kotlin {

    // Función que verifica si una palabra es un palíndromo
    private fun esPalindromo(palabra: String): Boolean {
        // Paso 1: Convertir toda la palabra a minúsculas
        val palabraLowerCase = palabra.lowercase()

        // Paso 2: Eliminar los espacios de la palabra
        val palabraSinEspacios = palabraLowerCase.replace(" ", "")

        // Paso 3: Comparar si la palabra sin espacios es igual a su reverso
        return palabraSinEspacios == palabraSinEspacios.reversed()
    }

    // Caso de prueba
    @Test
    fun testPalabra() {
        // Defino las palabras a probar
        val palabra1 = "Racecar"
        val palabra2 = "Kotlin"

        // Imprimo la palabra 1
        println("Palabra ingresada: $palabra1")

        // Verifico si la palabra es un palíndromo
        val resultado1 = esPalindromo(palabra1)

        // Implemento condicional para mostrar el resultado
        //En caso cumpla la condición
        if (resultado1) {
            // Imprimo el resultado
            println("La palabra '$palabra1' se lee igual de derecho y reverso.")
        //En caso no cumpla la condición
        } else {
            // Imprimo el resultado
            println("La palabra '$palabra1' no se lee igual de derecho y reverso.")
        }

        // Imprimo la palabra 2
        println("\nPalabra ingresada: $palabra2")

        // Verifico si la palabra es un palíndromo
        val resultado2 = esPalindromo(palabra2)

        // Implemento condicional para mostrar el resultado
        //En caso cumpla la condición
        if (resultado2) {
            // Imprimo el resultado
            println("La palabra '$palabra2' se lee igual de derecho y reverso.")
        //En caso no cumpla la condición
        } else {
            // Imprimo el resultado
            println("La palabra '$palabra2' no se lee igual de derecho y reverso.")
        }
    }
}