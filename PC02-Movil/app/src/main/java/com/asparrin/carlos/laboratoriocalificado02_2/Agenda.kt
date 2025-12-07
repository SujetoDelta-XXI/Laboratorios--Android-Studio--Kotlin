package com.asparrin.carlos.laboratoriocalificado02_2

import kotlin.collections.filter
import kotlin.collections.forEach
import kotlin.text.equals
import kotlin.text.orEmpty
import kotlin.text.toIntOrNull

class Contacto(val nombre: String, val telefono: String, val email: String) {
    fun mostrarInfo() {
        println("Nombre: $nombre - Telefono: $telefono - Email: $email")
    }
}

class Agenda {
    private val contactos = mutableListOf<Contacto>()

    fun agregarContacto(contacto: Contacto) {
        contactos.add(contacto)
        println("Contacto agregado correctamente.")
    }
    fun listarContactos() {
        if (contactos.isEmpty()) {
            println("No hay contactos en la agenda.")
        } else {
            println("Lista de Contactos:")
            contactos.forEach { it.mostrarInfo() }
        }
    }
    fun buscarContacto(nombreBuscado: String) {
        val encontrados = contactos.filter { it.nombre.equals(nombreBuscado, ignoreCase = true) }
        if (encontrados.isEmpty()) {
            println("No se encontro ningún contacto con ese nombre.")
        } else {
            println("Resultados encontrados:")
            encontrados.forEach { it.mostrarInfo() }
        }
    }
}

fun main() {
    val agenda = Agenda()
    var opcion: Int

    do {
        println("\n===== AGENDA DE CONTACTOS =====")
        println("1. Agregar un contacto")
        println("2. Listar todos los contactos")
        println("3. Buscar un contacto por nombre")
        println("4. Salir")
        print("Seleccione una opcion: ")

        opcion = readLine()?.toIntOrNull() ?: 0

        when (opcion) {
            1 -> {
                println("\n--- Agregar Contacto ---")
                print("Nombre: ")
                val nombre = readLine().orEmpty()

                print("Telefono: ")
                val telefono = readLine().orEmpty()

                print("Email: ")
                val email = readLine().orEmpty()

                val nuevoContacto = Contacto(nombre, telefono, email)
                agenda.agregarContacto(nuevoContacto)
            }
            2 -> {
                println("\n--- Lista de Contactos ---")
                agenda.listarContactos()
            }
            3 -> {
                println("\n--- Buscar Contacto ---")
                print("Ingrese el nombre a buscar: ")
                val nombreBuscar = readLine().orEmpty()
                agenda.buscarContacto(nombreBuscar)
            }
            4 -> println("Saliendo del programa...")
            else -> println("Opcion no válida. Intente de nuevo.")
        }
    } while (opcion != 4)
}
