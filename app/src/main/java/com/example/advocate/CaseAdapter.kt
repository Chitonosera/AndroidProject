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

class CaseAdapter(private var cases: MutableList<Case>) : RecyclerView.Adapter<CaseAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_case_adapter, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val Case = cases[position]
        holder.bind(Case)

        fun showEditCaseDialog(Case: Case, position: Int) {
            val builder = AlertDialog.Builder(holder.itemView.context)
            builder.setTitle("Редагувати")

            val view =
                LayoutInflater.from(holder.itemView.context).inflate(R.layout.dialog_case, null)
            builder.setView(view)

            val editTextCaseName = view.findViewById<EditText>(R.id.tvCaseName)
            val editTextSubject = view.findViewById<EditText>(R.id.tvSubject)

            editTextCaseName.setText(Case.name)
            editTextSubject.setText(Case.subject)

            builder.setPositiveButton("Оновити") { dialog, _ ->
                val newCaseName = editTextCaseName.text.toString()
                val newSubject = editTextSubject.text.toString()

                if (newCaseName.isNotEmpty() && newSubject.isNotEmpty()) {
                    val updatedCase = Case(newCaseName, newSubject)
                    updateCase(position, updatedCase)
                } else {
                    Toast.makeText(holder.itemView.context, "Заповніть поля", Toast.LENGTH_SHORT)
                        .show()
                }
                dialog.dismiss()
            }

            builder.setNegativeButton("Скасувати") { dialog, _ ->
                dialog.dismiss()
            }

            builder.create().show()
        }

        holder.itemView.setOnClickListener {
            showEditCaseDialog(Case, position)
        }
    }

    override fun getItemCount(): Int {
        return cases.size
    }

    fun addItem(Case: Case) {
        cases.add(Case)
        notifyItemInserted(cases.size - 1)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(Case: Case) {
            itemView.findViewById<TextView>(R.id.tvCaseName).text = Case.name
            itemView.findViewById<TextView>(R.id.tvSubject).text = Case.subject

            itemView.findViewById<Button>(R.id.btnDelete).setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    cases.removeAt(position)
                    notifyItemRemoved(position)
                }
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateCase(position: Int, updateCase: Case) {
        val updatedList = cases.toMutableList()
        updatedList[position] = updateCase
        cases = updatedList
        notifyItemChanged(position)
    }
}
