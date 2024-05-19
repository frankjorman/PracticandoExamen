package com.example.multiapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnTkambio: Button = findViewById(R.id.btnTkambio)
        val btnEdadDias: Button = findViewById(R.id.btnEdadDias)
        val btnContactos: Button = findViewById(R.id.btnContactos)

        btnTkambio.setOnClickListener{
            val intent = Intent(this,CambioActivity::class.java)
            startActivity(intent)
        }

        btnEdadDias.setOnClickListener{
            val intent = Intent(this,EdadActivity::class.java)
            startActivity(intent)
        }

        btnContactos.setOnClickListener{
            val intent = Intent(this,ContactoActivity::class.java)
            startActivity(intent)
        }
    }

}