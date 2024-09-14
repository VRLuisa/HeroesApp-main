package com.example.heroesapp_main.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.heroesapp_main.R
import com.example.heroesapp_main.models.Hero
import com.squareup.picasso.Picasso

class HeroAdapter(
    private val heroes: List<Hero>,
    private val onItemClick: (Hero) -> Unit
) : RecyclerView.Adapter<HeroAdapter.HeroViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.hero_item, parent, false)
        return HeroViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        val hero = heroes[position]
        holder.heroNameTextView.text = hero.name
        holder.heroDescriptionTextView.text = hero.description
        Picasso.get().load(hero.image).into(holder.heroImageView)

        holder.itemView.setOnClickListener {
            onItemClick(hero)
        }
    }

    override fun getItemCount() = heroes.size

    class HeroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val heroNameTextView: TextView = itemView.findViewById(R.id.hero_name_text_view)
        val heroDescriptionTextView: TextView = itemView.findViewById(R.id.hero_description_text_view)
        val heroImageView: ImageView = itemView.findViewById(R.id.hero_image_view)
    }
}
