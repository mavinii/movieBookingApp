package com.marcosoliveira.moviebookingapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.NotificationCompat.getColor
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
        holder.movieGenres.text = currentItem.genres
        holder.movieRunningTime.text = currentItem.runningTime
        holder.movieSeatsRemaining.text = currentItem.movieSeatsRemaining.toString()


//        // Adding or removing seats
//        val numSeatsTextView = holder.itemView.findViewById<TextView>(R.id.num_seats)
//        val btnMinus = holder.itemView.findViewById<ImageView>(R.id.btn_minus)
//        val btnPlus = holder.itemView.findViewById<ImageView>(R.id.btn_plus)
//
//        // Adding or remove the number of seats
//        numSeatsTextView.text = currentItem.numSeats.toString()
//        if(currentItem.numSeats > 0){
//            numSeatsTextView.visibility = View.VISIBLE
//            btnPlus.setColorFilter(getColor(context, R.color.main_color))
//        }

    }

    // getItemCount is part of RecycleView
    override fun getItemCount(): Int {
        return newsList.size
    }


    class MovieViewHolder(itemView : View, listener: OnItemClickListener) : RecyclerView.ViewHolder(itemView){

        // Connecting the IDs of my activity_movie with its var
        val titleImage : ShapeableImageView = itemView.findViewById(R.id.title_image)
        val movieTitle : TextView = itemView.findViewById(R.id.movie_title)
        val movieDescription : TextView = itemView.findViewById(R.id.movie_description)
        val movieGenres : TextView = itemView.findViewById(R.id.movie_genres)
        val movieRunningTime : TextView = itemView.findViewById(R.id.movie_running_time)
        val movieSeatsRemaining : TextView = itemView.findViewById(R.id.movie_seats_remaining)


        // Connecting the IDs of my activity_movie (seats Minus and PLus)
//        val numSeatsTextView : TextView = itemView.findViewById(R.id.num_seats)
//        val btnMinus :  ShapeableImageView = itemView.findViewById(R.id.btn_minus)
//        val btnPlus :  ShapeableImageView = itemView.findViewById(R.id.btn_plus)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(absoluteAdapterPosition) //(adapterPosition)
            }
        }


    }
}
