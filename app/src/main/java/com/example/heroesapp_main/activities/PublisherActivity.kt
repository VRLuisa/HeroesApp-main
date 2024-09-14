package com.example.heroesapp_main.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.heroesapp_main.R
import com.example.heroesapp_main.adapters.PublisherAdapter
import com.example.heroesapp_main.models.Publisher

class PublisherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_publisher)

        val publisherRecyclerView = findViewById<RecyclerView>(R.id.publisher_recycler_view)
        publisherRecyclerView.layoutManager = LinearLayoutManager(this)

        val publishers = listOf(
            Publisher(1, "Marvel", "https://example.com/marvel_logo.png"),
            Publisher(2, "DC", "https://example.com/dc_logo.png")
        )

        val adapter = PublisherAdapter(publishers) { publisher ->
            // Aquí agregamos la navegación a HeroesActivity
            val intent = Intent(this, HeroesActivity::class.java)
            intent.putExtra("publisherId", publisher.id) // Pasamos el ID del publisher a la siguiente actividad
            startActivity(intent)
        }
        publisherRecyclerView.adapter = adapter
    }
}