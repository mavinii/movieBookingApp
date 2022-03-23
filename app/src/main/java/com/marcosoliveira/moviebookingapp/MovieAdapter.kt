package com.marcosoliveira.moviebookingapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.marcosoliveira.moviebookingapp.Movie

// font: https://www.youtube.com/watch?v=UbP8E6I91NA
class MovieAdapter(private val posts: ArrayList<Movie>) : RecyclerView.Adapter<MovieViewHolder>() {

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflator = LayoutInflater.from(parent.context)
        val view =  inflator.inflate(R.layout.movie_list, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        val post = posts[position]
        holder.itemView.findViewById<TextView>(R.id.movie_title).text = post.title
        holder.itemView.findViewById<TextView>(R.id.movie_description).text = post.title

        val imageView = holder.itemView.findViewById<TextView>(R.id.movie_img)
    }

    // It returns how many items we have in our recycle view
    override fun getItemCount(): Int {
        return posts.size
    }

}

class MovieViewHolder(val v: View) : RecyclerView.ViewHolder(v)
