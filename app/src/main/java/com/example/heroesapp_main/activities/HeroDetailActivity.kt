package com.example.heroesapp_main.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import com.example.heroesapp_main.R
import com.squareup.picasso.Picasso

class HeroDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hero_detail)

        val heroNameTextView = findViewById<TextView>(R.id.hero_name_text_view)
        val heroDescriptionTextView = findViewById<TextView>(R.id.hero_description_text_view)
        val heroImageView = findViewById<ImageView>(R.id.hero_image_view)

        // Recibimos los datos del héroe desde la intención
        val heroName = intent.getStringExtra("heroName")
        val heroDescription = intent.getStringExtra("heroDescription")
        val heroImage = intent.getStringExtra("heroImage")

        // Llenamos los TextViews con los datos del héroe
        heroNameTextView.text = heroName
        heroDescriptionTextView.text = heroDescription

        // Cargamos la imagen del héroe con Picasso
        Picasso.get().load(heroImage).into(heroImageView)
    }
}