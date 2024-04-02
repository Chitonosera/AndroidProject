package com.example.advocate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        findViewById<Button>(R.id.btn_logout).setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        val btnTeachers = findViewById<Button>(R.id.btn_case)
        val btnDesc = findViewById<Button>(R.id.btn_desc)

        btnTeachers.setOnClickListener {
            startActivity(Intent(this,CaseActivity::class.java))
        }

        btnDesc.setOnClickListener {
            startActivity(Intent(this, DescActivity::class.java))
        }

        findViewById<Button>(R.id.btn_logout).setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

}