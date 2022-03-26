package com.marcosoliveira.moviebookingapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

// font: https://www.youtube.com/watch?v=UbP8E6I91NA
class MovieAdapter(private val newsList : ArrayList<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    // Local var mListener
    private lateinit var mListener : OnItemClickListener


    // This function helps us to create click listener with Toast
    interface OnItemClickListener{
        fun onItemClick(position : Int)
    }

    // mListener is a local var; listener is passing by argument
    fun setOnItemClickListener(listener: OnItemClickListener){
        mListener = listener
    }


    // onCreateViewHolder is part of RecycleView
     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.movie_list, parent, false)
        return MovieViewHolder(itemView, mListener)
    }

    // onBindViewHolder is part of RecycleView
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        val currentItem = newsList[position]

        holder.titleImage.setImageResource(currentItem.titleImage)
        holder.movieTitle.text = currentItem.title
        holder.movieDescription.text = currentItem.description

//        holder.movieGenres.text = currentMovie.genres
//        holder.movieRunningTime.text = currentMovie.runningTime

    }

    // getItemCount is part of RecycleView
    override fun getItemCount(): Int {
        return newsList.size
    }


    class MovieViewHolder(itemView : View, listener: OnItemClickListener) : RecyclerView.ViewHolder(itemView){

        val titleImage : ShapeableImageView = itemView.findViewById(R.id.title_image)
        val movieTitle : TextView = itemView.findViewById(R.id.movie_title)
        val movieDescription : TextView = itemView.findViewById(R.id.movie_description)

//        var movieGenres : TextView = itemView.findViewById(R.id.movie_genres)
//        var movieRunningTime : TextView = itemView.findViewById(R.id.movie_running_time)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(absoluteAdapterPosition) //(adapterPosition)
            }
        }


    }
}
