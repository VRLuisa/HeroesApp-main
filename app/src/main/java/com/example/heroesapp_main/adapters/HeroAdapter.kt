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

class HeroAdapter(private val heroList: List<Hero>, private val onHeroClick: (Hero) -> Unit) :
    RecyclerView.Adapter<HeroAdapter.HeroViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.hero_item, parent, false)
        return HeroViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        val hero = heroList[position]
        holder.heroNameTextView.text = hero.name
        Picasso.get().load(hero.image).into(holder.heroImageView)

        holder.itemView.setOnClickListener {
            onHeroClick(hero)
        }
    }

    override fun getItemCount(): Int = heroList.size

    class HeroViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val heroImageView: ImageView = view.findViewById(R.id.hero_image_view)
        val heroNameTextView: TextView = view.findViewById(R.id.hero_name_text_view)
    }
}
