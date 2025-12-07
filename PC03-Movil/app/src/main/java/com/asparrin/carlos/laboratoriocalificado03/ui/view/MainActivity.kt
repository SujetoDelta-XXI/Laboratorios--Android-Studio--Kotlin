package com.asparrin.carlos.laboratoriocalificado03.ui.view

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.asparrin.carlos.laboratoriocalificado03.R
import com.asparrin.carlos.laboratoriocalificado03.databinding.ActivityMainBinding
import com.asparrin.carlos.laboratoriocalificado03.data.model.TeachersResponse
import com.asparrin.carlos.laboratoriocalificado03.data.network.ApiClient
import com.asparrin.carlos.laboratoriocalificado03.ui.adapter.TeacherAdapter
import com.asparrin.carlos.laboratoriocalificado03.util.Constants
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: TeacherAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecycler()
        loadTeachers()
    }

    private fun setupRecycler() = with(binding.rvTeachers) {
        layoutManager = GridLayoutManager(this@MainActivity, 2)
        adapter = TeacherAdapter(
            emptyList(),
            onClick = { teacher -> dialPhone(teacher.phoneNumber) },
            onLongClick = { teacher -> sendEmail(teacher.email) }
        ).also { this@MainActivity.adapter = it }
        val spacing = resources.getDimensionPixelSize(R.dimen.card_spacing)
        addItemDecoration(GridSpacingItemDecoration(2, spacing, true))
    }

    private fun hasInternetConnection(): Boolean {
        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = cm.activeNetwork ?: return false
        val caps = cm.getNetworkCapabilities(network) ?: return false
        return caps.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }

    private fun loadTeachers() {
        if (!hasInternetConnection()) {
            Toast.makeText(this, getString(R.string.error_network), Toast.LENGTH_LONG).show()
            return
        }

        lifecycleScope.launch {
            try {
                val response = ApiClient.teacherService.getTeachers(Constants.TEACHERS_URL)
                if (response.isSuccessful) {
                    val teachers = response.body()?.teachers.orEmpty()
                    Log.d("DEBUG_ADAPTER", "Recibidos ${teachers.size} docentes")
                    adapter.updateData(teachers)
                } else {
                    Log.e("DEBUG_ADAPTER", "Error HTTP ${response.code()}")
                    Toast.makeText(
                        this@MainActivity,
                        getString(R.string.error_network),
                        Toast.LENGTH_LONG
                    ).show()
                }
            } catch (e: Exception) {
                Log.e("DEBUG_ADAPTER", "Excepción: ${e.message}", e)
                Toast.makeText(
                    this@MainActivity,
                    "Error de red: ${e.localizedMessage}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    private fun dialPhone(number: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$number")
        }
        startActivity(intent)
    }

    private fun sendEmail(email: String) {
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "message/rfc822"
            putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
            putExtra(Intent.EXTRA_SUBJECT, "Consulta desde la app")
        }
        // Usa un chooser para que el usuario elija su cliente de correo
        val chooser = Intent.createChooser(intent, "Enviar email con...")
        // Y sólo mostramos el Toast si no hay nada que pueda manejar el intent
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(chooser)
        } else {
            Toast.makeText(this, "No hay app de correo instalada", Toast.LENGTH_SHORT).show()
        }
    }

}
