package com.asparrin.carlos.laboratoriocalificado02_2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.asparrin.carlos.laboratoriocalificado02_2.databinding.ActivityEjercicio01Binding

class Ejercicio01 : AppCompatActivity() {

    private lateinit var binding: ActivityEjercicio01Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityEjercicio01Binding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.viewVerde.visibility = android.view.View.VISIBLE

        // Botón Mostrar
        binding.btnMostrar.setOnClickListener {
            binding.viewVerde.visibility = android.view.View.VISIBLE
        }

        // Botón Ocultar
        binding.btnOcultar.setOnClickListener {
            binding.viewVerde.visibility = android.view.View.INVISIBLE
        }
    }
}