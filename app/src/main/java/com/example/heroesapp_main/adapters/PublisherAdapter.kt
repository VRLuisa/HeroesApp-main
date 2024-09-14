package com.example.heroesapp_main.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.heroesapp_main.R
import com.example.heroesapp_main.models.Publisher
import com.squareup.picasso.Picasso

class PublisherAdapter(private val publisherList: List<Publisher>, private val onPublisherClick: (Publisher) -> Unit) :
    RecyclerView.Adapter<PublisherAdapter.PublisherViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PublisherViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.publisher_item, parent, false)
        return PublisherViewHolder(view)
    }

    override fun onBindViewHolder(holder: PublisherViewHolder, position: Int) {
        val publisher = publisherList[position]
        holder.publisherNameTextView.text = publisher.name
        Picasso.get().load(publisher.image).into(holder.publisherImageView)

        holder.itemView.setOnClickListener {
            onPublisherClick(publisher)
        }
    }

    override fun getItemCount(): Int = publisherList.size

    class PublisherViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val publisherImageView: ImageView = view.findViewById(R.id.publisher_image_view)
        val publisherNameTextView: TextView = view.findViewById(R.id.publisher_name_text_view)
    }
}

