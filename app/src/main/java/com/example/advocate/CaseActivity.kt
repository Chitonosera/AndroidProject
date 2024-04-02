package com.example.advocate

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CaseActivity : AppCompatActivity() {
    lateinit var adapter: CaseAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_case)
        findViewById<Button>(R.id.btnADD).setOnClickListener {
            showAddCaseDialog()
        }


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewCase)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = CaseAdapter(getCase())
        recyclerView.adapter = adapter

        findViewById<Button>(R.id.btn_back).setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
        }

    }

    private fun showAddCaseDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Додати пару")

        val view = layoutInflater.inflate(R.layout.dialog_case, null)
        builder.setView(view)

        val CaseName = view.findViewById<EditText>(R.id.tvCaseName)
        val ShortDesc = view.findViewById<EditText>(R.id.tvSubject)


        builder.setPositiveButton("Додати") { dialog, _ ->
            val CaseName = CaseName.text.toString()
            val ShortDesc = ShortDesc.text.toString()

            if (CaseName.isNotEmpty() && ShortDesc.isNotEmpty()) {
                val newCase = Case(CaseName, ShortDesc)
                adapter.addItem(newCase)
            } else {
                Toast.makeText(this, "Будь ласка, заповніть всі поля", Toast.LENGTH_SHORT).show()
            }
            dialog.dismiss()
        }


        builder.setNegativeButton("Відмінити") { dialog, _ ->
            dialog.dismiss()
        }

        builder.create().show()
    }

    private fun getCase(): MutableList<Case> {
        return mutableListOf(
            Case("John Doe", "Math"),
            Case("Jane Smith", "English"),
            Case("Michael Johnson", "Physics")
        )
    }
}
