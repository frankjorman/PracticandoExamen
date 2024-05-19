package com.example.multiapp

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fragments.model.ContactoAdapter
import fragments.model.ContactosModel

class ContactoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_contacto)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Cambiado de view.findViewById a findViewById
        val rvContacto: RecyclerView = findViewById(R.id.rvContactos)

        // Cambiado de requireContext() a this
        rvContacto.layoutManager = LinearLayoutManager(this)
        rvContacto.adapter = ContactoAdapter(ContactosList())

    }
    private fun ContactosList(): List<ContactosModel>{
        val lstContacto: ArrayList<ContactosModel> = ArrayList()

        lstContacto.add(
            ContactosModel(1,R.drawable.imagen2,"frank","34534534","11-22-22")
        )

        lstContacto.add(
            ContactosModel(1,R.drawable.imagen3,"frank","34534534","11-22-22")
        )

        lstContacto.add(
            ContactosModel(1,R.drawable.imagen4,"frank","34534534","11-22-22")
        )

        lstContacto.add(
            ContactosModel(1,R.drawable.imagen5,"frank","34534534","11-22-22")
        )

        return  lstContacto;
    }
}