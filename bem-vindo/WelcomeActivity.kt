package com.seubanco.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class WelcomeActivity : AppCompatActivity() {

    private lateinit var tvUserName: TextView
    private lateinit var btnLogout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        tvUserName = findViewById(R.id.tvUserName)
        btnLogout = findViewById(R.id.btnLogout)

        // Pega o nome do usuário que foi enviado da tela anterior
        val userName = intent.getStringExtra("USER_NAME")
        if (userName != null) {
            tvUserName.text = userName
        }

        btnLogout.setOnClickListener {
            finish() // Fecha esta tela e volta para a anterior
        }
    }
}