package com.example.heroesapp_main.activities

import HeroesActivity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.heroesapp_main.R
import com.example.heroesapp_main.adapters.PublisherAdapter
import com.example.heroesapp_main.models.Publisher
import android.widget.Button

class PublisherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_publisher)
        Log.d("PublisherActivity", "Cargando la lista de publishers")


        val publisherRecyclerView = findViewById<RecyclerView>(R.id.publisher_recycler_view)
        publisherRecyclerView.layoutManager = LinearLayoutManager(this)

        val publishers = listOf(
            Publisher(1, "Marvel", "https://example.com/marvel_logo.png"),
            Publisher(2, "DC", "https://example.com/dc_logo.png")
        )

        val adapter = PublisherAdapter(publishers) { publisher ->
            val intent = Intent(this, HeroesActivity::class.java)
            intent.putExtra("publisherId", publisher.id)
            startActivity(intent)
        }
        publisherRecyclerView.adapter = adapter

        // Implementar el botón de Cerrar Sesión
        val logoutButton = findViewById<Button>(R.id.logout_button)
        logoutButton.setOnClickListener {
            val sharedPreferences = getSharedPreferences("HeroesApp", Context.MODE_PRIVATE)
            sharedPreferences.edit().putBoolean("isLogged", false).apply()

            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }
}