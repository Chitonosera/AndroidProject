package com.example.advocate

import android.annotation.SuppressLint
import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
class DescAdapter(private val descList: MutableList<Desc>, private val onItemClick: (Desc) -> Unit) : RecyclerView.Adapter<DescAdapter.DescViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DescViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.dialog_desc, parent, false)
        return DescViewHolder(view)
    }

    override fun onBindViewHolder(holder: DescViewHolder, position: Int) {
        val desc = descList[position]
        holder.bind(desc)
    }

    override fun getItemCount(): Int {
        return descList.size
    }

    inner class DescViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvDescName: TextView = itemView.findViewById(R.id.tvDescName)
        private val tvShortDesc: TextView = itemView.findViewById(R.id.tvShortDesc)

        fun bind(desc: Desc) {
            tvDescName.text = desc.name
            tvShortDesc.text = desc.shortDesc

            itemView.setOnClickListener {
                onItemClick(desc)
            }
        }
    }
}

