package com.example.advocate

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DescActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_desc)



        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewDesc)
        recyclerView.layoutManager = LinearLayoutManager(this)
        var adapter = DescAdapter(getDesc())
        recyclerView.adapter = adapter

        findViewById<Button>(R.id.btn_back).setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
        }

    }

    private fun showCaseDetailDialog(desc: Desc) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Детальна інформація")

        val view = layoutInflater.inflate(R.layout.dialog_desc, null)
        builder.setView(view)

        val tvDescName = view.findViewById<TextView>(R.id.tvDescName)
        val tvShortDesc = view.findViewById<TextView>(R.id.tvShortDesc)

        tvDescName.text = desc.name
        tvShortDesc.text = desc.shortDesc

        builder.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss()
        }

        builder.create().show()
    }

    private fun getDesc(): MutableList<Desc> {
        return mutableListOf(
            Desc("John 228", "Math"),
            Desc("Jane Smith", "English"),
            Desc("Michael Johnson", "Physics")
        )
    }
}
