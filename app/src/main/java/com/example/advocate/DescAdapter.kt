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
class DescAdapter(private var descs: MutableList<Desc>) : RecyclerView.Adapter<DescAdapter.ViewHolder>() {
    interface OnItemClickListener {
        fun onItemClick(desc: Desc)
    }

    private var onItemClickListener: OnItemClickListener? = null

    override fun getItemCount(): Int {
        return descs.size
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.onItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.dialog_desc, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val desc = descs[position]
        holder.bind(desc)

        holder.itemView.setOnClickListener {
            onItemClickListener?.onItemClick(desc)
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(desc: Desc) {
            val tvDescName = itemView.findViewById<TextView>(R.id.tvDescName)
            val tvShortDesc = itemView.findViewById<TextView>(R.id.tvShortDesc)

            tvDescName.text = desc.name
            tvShortDesc.text = desc.shortDesc
        }
    }
}
