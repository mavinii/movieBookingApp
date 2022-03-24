package com.marcosoliveira.moviebookingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var newRecycleView : RecyclerView
    private lateinit var newArrayList : ArrayList<Movie>

    // variables of the movie
    lateinit var imageId : Array<Int>
    lateinit var title : Array<String>
    lateinit var descrition : Array<String>
    lateinit var genres : Array<String>
    lateinit var running_time_min : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Array that displays all the images
        imageId = arrayOf(
            R.drawable.fantastic_beasts_the_secrets_of_bumbledore_poster,
            R.drawable.ambulance_poster,
            R.drawable.sonic_2_poster,
            R.drawable.the_batmain_poster,
            R.drawable.uncharted_poster
        )

        // Array that brings all the Titles from strings.xml file
        title = arrayOf(
            getString(R.string.movie_title_1),
            getString(R.string.movie_title_2),
            getString(R.string.movie_title_3),
            getString(R.string.movie_title_4),
            getString(R.string.movie_title_5)
        )

        // Array that brings all the Description from strings.xml file
        descrition = arrayOf(
            getString(R.string.movie_description_1),
            getString(R.string.movie_description_2),
            getString(R.string.movie_description_3),
            getString(R.string.movie_description_4),
            getString(R.string.movie_description_5)
        )

        // Array that display all the genres
        genres = arrayOf(
            getString(R.string.genre_movie_1),
            getString(R.string.genre_movie_2),
            getString(R.string.genre_movie_3),
            getString(R.string.genre_movie_4),
            getString(R.string.genre_movie_5)
        )

        // An Array that display all the running time
        running_time_min = arrayOf(
            getString(R.string.movie_running_time_1),
            getString(R.string.movie_running_time_2),
            getString(R.string.movie_running_time_3),
            getString(R.string.movie_running_time_4),
            getString(R.string.movie_running_time_5)
        )

        newRecycleView = findViewById(R.id.recycleView)
        newRecycleView.layoutManager = LinearLayoutManager(this)
        newRecycleView.setHasFixedSize(true)

        newArrayList = arrayListOf<Movie>()
        getUserdata()
    }

    // Method for running all contents of the array
    private fun getUserdata() {
        for (i in imageId.indices){
            val news = Movie(imageId[i], title[i], descrition[i], genres[i], running_time_min[i])
            newArrayList.add(news)
        }

        newRecycleView.adapter = MovieAdapter(newArrayList)

    }
}