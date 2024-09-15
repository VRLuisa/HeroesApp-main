package com.example.heroesapp_main.activities

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.heroesapp_main.R
import com.squareup.picasso.Picasso

class HeroDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hero_detail)

        val heroName = intent.getStringExtra("heroName") ?: "Sin nombre"
        val heroDescription = intent.getStringExtra("heroDescription") ?: "Sin descripción"
        val heroImage = intent.getStringExtra("heroImage") ?: ""

        val heroImageView = findViewById<ImageView>(R.id.hero_image_view)
        val heroNameTextView = findViewById<TextView>(R.id.hero_name_text_view)
        val heroDescriptionTextView = findViewById<TextView>(R.id.hero_description_text_view)

        heroNameTextView.text = heroName
        heroDescriptionTextView.text = heroDescription

        // Cargar la imagen usando Picasso (asegúrate de que tienes el URL correcto de la imagen)
        Picasso.get().load(heroImage).into(heroImageView)
    }
}