package com.asparrin.carlos.laboratoriocalificado02_2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.asparrin.carlos.laboratoriocalificado02_2.databinding.ActivityPedidoBinding

class PedidoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPedidoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPedidoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nombre = intent.getStringExtra("nombre") ?: ""
        val numero = intent.getStringExtra("numero") ?: ""
        val productos = intent.getStringExtra("productos") ?: ""
        val ciudad = intent.getStringExtra("ciudad") ?: ""
        val direccion = intent.getStringExtra("direccion") ?: ""

        binding.tvNombreCliente.text = nombre
        binding.tvNumeroCliente.text = numero
        binding.tvProductos.text = productos
        binding.tvUbicacion.text = "$ciudad, $direccion"

        binding.btnLlamar.setOnClickListener {
            val mensaje = "Nombre: $nombre\nNúmero: $numero\nProductos: $productos\nDirección: $ciudad, $direccion"
            Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
        }

        binding.btnWsp.setOnClickListener {
            val mensaje = "Hola $nombre Tus productos: $productos están en camino a la dirección: $ciudad, $direccion"
            Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
        }

        binding.btnMaps.setOnClickListener {
            val mensaje = "Mostrar en MAPS la dirección:\n$ciudad, $direccion"
            Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
        }
    }
}