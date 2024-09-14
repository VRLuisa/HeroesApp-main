package com.example.heroesapp_main.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.heroesapp_main.R
import com.example.heroesapp_main.models.User
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences("HeroesApp", Context.MODE_PRIVATE)

        val isLogged = sharedPreferences.getBoolean("isLogged", false)
        if (isLogged) {
            // Si el usuario ya está logueado, ir directamente a PublisherActivity
            navigateToPublisherActivity()
        }

        emailEditText = findViewById(R.id.email_edit_text)
        passwordEditText = findViewById(R.id.password_edit_text)
        loginButton = findViewById(R.id.login_button)

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Validar email y contraseña
            if (isValidUser(email, password)) {
                // Guardar el estado de login en SharedPreferences
                sharedPreferences.edit().putBoolean("isLogged", true).apply()

                // Navegar a PublisherActivity
                navigateToPublisherActivity()
            } else {
                // Mostrar Snackbar de error
                Snackbar.make(it, "Email o contraseña incorrectos", Snackbar.LENGTH_LONG).show()
            }
        }
    }

    private fun isValidUser(email: String, password: String): Boolean {
        // Lista de usuarios válidos
        val validUsers = listOf(
            User("user1@example.com", "password123"),
            User("user2@example.com", "password456")
        )

        return validUsers.any { it.email == email && it.password == password }
    }

    private fun navigateToPublisherActivity() {
        val intent = Intent(this, PublisherActivity::class.java)
        startActivity(intent)
        finish() // Evitar volver al login
    }
}