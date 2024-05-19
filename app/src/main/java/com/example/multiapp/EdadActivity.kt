package com.example.multiapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.SimpleDateFormat
import java.util.Date
import kotlin.math.abs

class EdadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_edad)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etFechaNac: TextView = findViewById(R.id.txtFechaNacimiento)
        val etResultadoEdad= findViewById<TextView>(R.id.txtEdadDias)
        val btCalcularEdad: Button = findViewById(R.id.btnCalcularDias)

        btCalcularEdad.setOnClickListener{
            var resultadoEdad = calcularEdadDias(etFechaNac.text.toString())
            etResultadoEdad.text = resultadoEdad.toString()
        }
    }

    fun calcularEdadDias(fechaDeInicio: String): Int {
        // Obtener la fecha actual en formato "dd/MM/yyyy"
        val dateFormat = SimpleDateFormat("dd/MM/yyyy")
        val stHoy = dateFormat.format(Date())

        // Parsear las fechas
        val date2: Date = dateFormat.parse(stHoy) ?: Date()
        val date3: Date = dateFormat.parse(fechaDeInicio) ?: Date()

        // Calcular la diferencia en milisegundos
        val difLong = abs(date3.time - date2.time)

        // Calcular la diferencia en días
        val diaDif = (difLong / (24 * 60 * 60 * 1000)).toInt()

        // Retornar la diferencia en días
        return diaDif
    }
}