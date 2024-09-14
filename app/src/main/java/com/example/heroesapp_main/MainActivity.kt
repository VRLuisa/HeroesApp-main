package com.example.heroesapp_main.activities

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.heroesapp_main.R
import com.example.heroesapp_main.models.User
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var sharedPreferences: SharedPreferences
    private val validUsers = listOf(
        User("example@example.com", "password123"),
        User("hero@marvel.com", "superhero"),
        User("hero@dc.com", "justiceleague")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencing UI elements
        emailEditText = findViewById(R.id.email_edit_text)
        passwordEditText = findViewById(R.id.password_edit_text)
        loginButton = findViewById(R.id.login_button)

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (validateEmail(email)) {
                authenticateUser(email, password)
            } else {
                showSnackbar("Email no válido")
            }
        }
    }

    private fun validateEmail(email: String): Boolean {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun authenticateUser(email: String, password: String) {
        val user = validUsers.find { it.email == email && it.password == password }
        if (user != null) {
            // Navegar a PublisherActivity y guardar el estado en SharedPreferences
            val intent = Intent(this, PublisherActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            showSnackbar("Usuario o contraseña incorrectos")
        }
    }

    private fun showSnackbar(message: String) {
        val rootLayout = findViewById<ConstraintLayout>(R.id.main)
        Snackbar.make(rootLayout, message, Snackbar.LENGTH_LONG).show()
    }
}