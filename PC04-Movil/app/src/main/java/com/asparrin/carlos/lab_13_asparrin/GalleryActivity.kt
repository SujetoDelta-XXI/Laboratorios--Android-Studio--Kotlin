package com.asparrin.carlos.lab_13_asparrin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.asparrin.carlos.lab_13_asparrin.databinding.ActivityGalleryBinding
import java.io.File

class GalleryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGalleryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGalleryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Directorio donde la cámara suele guardar las imágenes
        val directory = File(externalMediaDirs[0].absolutePath)
        val files = directory.listFiles()?.filter { it.isFile }?.toTypedArray() ?: emptyArray()

        // Invertimos el orden para mostrar las fotos más recientes al principio
        val adapter = GalleryAdapter(files.reversedArray())
        binding.viewPager.adapter = adapter
    }
}
