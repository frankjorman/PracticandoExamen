package com.example.multiapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CambioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cambio)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnCalcularCambio: Button = findViewById(R.id.btnCacularCambo)
        val etTipoCambio: TextView = findViewById(R.id.txtTipoCambio)
        val etMontoDolares: TextView = findViewById(R.id.txtMontoDolares)
        val etResultado= findViewById<TextView>(R.id.lblResultadoSoles)
        val etBilette100= findViewById<TextView>(R.id.lblBilletes100)
        val etBilette50= findViewById<TextView>(R.id.lblBilletes50)
        val etBilette20= findViewById<TextView>(R.id.lblBilletes20)


        btnCalcularCambio.setOnClickListener{
            var ImporteSoles = etTipoCambio.text.toString().toDouble() * etMontoDolares.text.toString().toDouble()
            etResultado.text = ImporteSoles.toString()
            var resultado = billetes(ImporteSoles)
            for ((billete, cantidad) in resultado) {
                if (billete== 100){
                    etBilette100.text = cantidad.toString() + " Billetes de " + billete.toString()
                }else if(billete== 50){
                    etBilette50.text = cantidad.toString() + " Billetes de " + billete.toString()
                }else if(billete== 20){
                    etBilette20.text = cantidad.toString() + " Billetes de " + billete.toString()
                }
            }
        }
    }

    fun billetes(monto: Double): Map<Int, Int> {
        // Definir las denominaciones de los billetes
        val billetes = listOf(100, 50, 20)
        val resultado = mutableMapOf<Int, Int>()

        // Convertir el monto a entero para trabajar con billetes
        var montoRestante = monto.toInt()

        for (billete in billetes) {
            val cantidadBilletes = montoRestante / billete
            if (cantidadBilletes > 0) {
                resultado[billete] = cantidadBilletes
                montoRestante %= billete
            }
        }
        return resultado
    }
}