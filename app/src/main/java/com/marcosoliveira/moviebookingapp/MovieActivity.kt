package com.marcosoliveira.moviebookingapp

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text
import androidx.recyclerview.widget.RecyclerView

class MovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
    }
//
//
//    // variables of the movie
//    val mainTitle : TextView = findViewById(R.id.movie_title)
//    val mainDescription : TextView = findViewById(R.id.movie_description)
//    val mainImage : ImageView = findViewById(R.id.movie_img)
//
////    val genres : TextView = findViewById(R.id.movie_genres)
////    val runningTime : TextView = findViewById(R.id.movie_running_time)
//
//
//    val bundle : Bundle?= intent.extras
//
//    val title = bundle!!.getString("title")
//    val image = bundle?.getInt("image")
//    val title = bundle?.getString("title")

//    THIS LINE NEEDS TO CONNECT FOR OPENING MY MOVIEACTIVITY
//    mainTitle.text = title

}