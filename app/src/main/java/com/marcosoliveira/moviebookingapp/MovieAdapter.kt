package com.marcosoliveira.moviebookingapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// font: https://www.youtube.com/watch?v=UbP8E6I91NA
class MovieAdapter(private val posts : ArrayList<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.movie_list, parent, false)
        return MovieViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        val currentMovie = posts[position]
        holder.movieImage.setImageResource(currentMovie.movie_img)
        holder.movieTitle.text = currentMovie.title
        holder.movieDescription.text = currentMovie.description
        holder.movieGenres.text = currentMovie.genres
        holder.movieRunningTime.text = currentMovie.running_time_min
    }

    // It returns how many items we have in our recycle view
    override fun getItemCount(): Int {
        return posts.size
    }

    class MovieViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val movieImage : ImageView = itemView.findViewById(R.id.movie_img)
        val movieTitle : TextView = itemView.findViewById(R.id.movie_title)
        val movieDescription : TextView = itemView.findViewById(R.id.movie_description)
        var movieGenres : TextView = itemView.findViewById(R.id.movie_genres)
        var movieRunningTime : TextView = itemView.findViewById(R.id.movie_running_time)
    }
}
