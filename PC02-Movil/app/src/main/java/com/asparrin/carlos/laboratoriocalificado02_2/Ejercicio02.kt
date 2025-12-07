package com.asparrin.carlos.laboratoriocalificado02_2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.asparrin.carlos.laboratoriocalificado02_2.databinding.ActivityEjercicio02Binding

class Ejercicio02 : AppCompatActivity() {

    private lateinit var binding: ActivityEjercicio02Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityEjercicio02Binding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnRegistrar.setOnClickListener {
            if (validarInputs()) {
                val intent = Intent(this, PedidoActivity::class.java).apply {
                    putExtra("nombre", binding.etNombreCliente.text.toString())
                    putExtra("numero", binding.etNumeroCliente.text.toString())
                    putExtra("productos", binding.etProductos.text.toString())
                    putExtra("ciudad", binding.etCiudad.text.toString())
                    putExtra("direccion", binding.etDireccion.text.toString())
                }
                startActivity(intent)
            }
        }
    }

    private fun validarInputs(): Boolean {
        var valido = true
        if (binding.etNombreCliente.text.isNullOrBlank()) {
            binding.etNombreCliente.error = "Ingrese nombre"
            valido = false
        }
        if (binding.etNumeroCliente.text.isNullOrBlank()) {
            binding.etNumeroCliente.error = "Ingrese número"
            valido = false
        }
        if (binding.etProductos.text.isNullOrBlank()) {
            binding.etProductos.error = "Ingrese productos"
            valido = false
        }
        if (binding.etCiudad.text.isNullOrBlank()) {
            binding.etCiudad.error = "Ingrese ciudad"
            valido = false
        }
        if (binding.etDireccion.text.isNullOrBlank()) {
            binding.etDireccion.error = "Ingrese dirección"
            valido = false
        }
        return valido
    }
}