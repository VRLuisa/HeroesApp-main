package com.example.heroesapp_main.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.heroesapp_main.R
import com.example.heroesapp_main.adapters.HeroAdapter
import com.example.heroesapp_main.models.Hero

class HeroesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heroes)

        val heroesRecyclerView = findViewById<RecyclerView>(R.id.heroes_recycler_view)
        heroesRecyclerView.layoutManager = LinearLayoutManager(this)

        val publisherId = intent.getIntExtra("publisherId", -1)

        val heroes = getHeroesForPublisher(publisherId)
        val adapter = HeroAdapter(heroes) { hero ->
            // Navegar a la pantalla de detalles del héroe
            val intent = Intent(this, HeroDetailActivity::class.java)
            intent.putExtra("heroName", hero.name)
            intent.putExtra("heroDescription", hero.description)
            intent.putExtra("heroImage", hero.image)
            startActivity(intent)
        }
        heroesRecyclerView.adapter = adapter
    }

    private fun getHeroesForPublisher(publisherId: Int): List<Hero> {
        return if (publisherId == 1) {
            listOf(
                Hero(1, "Iron Man", "Genius billionaire", "url_imagen", 1),
                // Agrega los demás héroes de Marvel aquí
            )
        } else {
            listOf(
                Hero(6, "Batman", "Dark Knight", "url_imagen", 2),
                // Agrega los demás héroes de DC aquí
            )
        }
    }
}