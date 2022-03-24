package com.marcosoliveira.moviebookingapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// font: https://www.youtube.com/watch?v=UbP8E6I91NA
class MovieAdapter(private val posts : ArrayList<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    // Local var mListener
    private lateinit var mListener : onItemClickListener


    // This function helps us to create click listener with Toast
    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    // listener is passing by argument
    fun setOnItemClickListener(listener: Any){
        mListener = listener as onItemClickListener
    }

    // onCreateViewHolder is part of RecycleView
     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.movie_list, parent, false)
        return MovieViewHolder(itemView, mListener)
    }

    // onBindViewHolder is part of RecycleView
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentMovie = posts[position]
        holder.movieImage.setImageResource(currentMovie.movie_img)
        holder.movieTitle.text = currentMovie.title
        holder.movieDescription.text = currentMovie.description
        holder.movieGenres.text = currentMovie.genres
        holder.movieRunningTime.text = currentMovie.running_time_min

    }

    // getItemCount is part of RecycleView
    override fun getItemCount(): Int {
        return posts.size
    }


    class MovieViewHolder(itemView : View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val movieImage : ImageView = itemView.findViewById(R.id.movie_img)
        val movieTitle : TextView = itemView.findViewById(R.id.movie_title)
        val movieDescription : TextView = itemView.findViewById(R.id.movie_description)
        var movieGenres : TextView = itemView.findViewById(R.id.movie_genres)
        var movieRunningTime : TextView = itemView.findViewById(R.id.movie_running_time)

        init {

            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }


        }
    }
}
