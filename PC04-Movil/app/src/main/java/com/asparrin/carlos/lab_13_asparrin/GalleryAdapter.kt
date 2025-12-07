package com.asparrin.carlos.lab_13_asparrin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.io.File
import com.asparrin.carlos.lab_13_asparrin.databinding.ListItemImgBinding

class GalleryAdapter(
    private val fileArray: Array<File>
) : RecyclerView.Adapter<GalleryAdapter.ViewHolder>() {

    inner class ViewHolder(
        private val binding: ListItemImgBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(file: File) {
            // Carga la imagen con Glide en el ImageView definido en tu layout
            Glide.with(binding.root)
                .load(file)
                .into(binding.localImg)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemImgBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(fileArray[position])
    }

    override fun getItemCount(): Int = fileArray.size
}