package com.example.multiapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val emailSuccess: String = "admin"
        val passwordSuccess: String = "123456"

        //capturar los elementos del formulario en variables
        val etEmail: EditText = findViewById(R.id.txtEmail)
        val etPassword: EditText = findViewById(R.id.txtPassword)
        val btnLogin: Button = findViewById(R.id.btnSignIn)

        btnLogin.setOnClickListener{
            val email:String =etEmail.text.trim().toString()
            val password:String =etPassword.text.trim().toString()

            //Valida si el usuario es correcto
            if(email==emailSuccess && password == passwordSuccess){
                    val intent = Intent(this,MenuActivity::class.java)
                    startActivity(intent)
            }

            //Muestra mensaje de error
            val rootView: View = findViewById(android.R.id.content)
            Snackbar.make(rootView,"Credenciales Invalidas", Snackbar.LENGTH_LONG).show()
        }
    }
}