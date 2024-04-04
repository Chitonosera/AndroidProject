package com.example.advocate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val sharedPreferences = getSharedPreferences(Const.MY_SHARE_PREFERENCE, MODE_PRIVATE)
        val userName = sharedPreferences.getString(Const.NAME, "") ?: ""
        val userLastName = sharedPreferences.getString(Const.LAST_NAME, "") ?: ""

        val welcomeMessage = "Welcome, $userName $userLastName!"
        val tvWelcome = findViewById<TextView>(R.id.tvWelcome)
        tvWelcome.text = welcomeMessage

        findViewById<Button>(R.id.btn_logout).setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        val btnTeachers = findViewById<Button>(R.id.btn_case)
        val btnDesc = findViewById<Button>(R.id.btn_desc)
        val btnProfile = findViewById<Button>(R.id.btn_profile)

        btnTeachers.setOnClickListener {
            startActivity(Intent(this, CaseActivity::class.java))
        }

        btnDesc.setOnClickListener {
            startActivity(Intent(this, DescActivity::class.java))
        }

        btnProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }
}