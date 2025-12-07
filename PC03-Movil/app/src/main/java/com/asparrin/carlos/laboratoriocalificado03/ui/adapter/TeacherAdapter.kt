package com.asparrin.carlos.laboratoriocalificado03.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.asparrin.carlos.laboratoriocalificado03.data.model.Teacher
import com.asparrin.carlos.laboratoriocalificado03.databinding.ItemTeacherBinding

class TeacherAdapter(
    private var list: List<Teacher>,
    private val onClick: (Teacher) -> Unit,
    private val onLongClick: (Teacher) -> Unit
) : RecyclerView.Adapter<TeacherAdapter.TeacherViewHolder>() {

    inner class TeacherViewHolder(private val b: ItemTeacherBinding) :
        RecyclerView.ViewHolder(b.root) {

        fun bind(t: Teacher) = with(b) {
            tvFirstName.text = t.firstName
            tvLastName.text  = t.lastName
            Glide.with(imgPhoto.context)
                .load(t.photoUrl)
                .into(imgPhoto)

            root.setOnClickListener {
                onClick(t)
            }

            root.setOnLongClickListener {
                onLongClick(t)
                true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        TeacherViewHolder(ItemTeacherBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: TeacherViewHolder, position: Int) =
        holder.bind(list[position])

    fun updateData(newList: List<Teacher>) {
        list = newList
        notifyDataSetChanged()
    }
}
