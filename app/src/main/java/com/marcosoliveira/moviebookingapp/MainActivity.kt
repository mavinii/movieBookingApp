package com.marcosoliveira.moviebookingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {

    private lateinit var newRecycleView : RecyclerView
    private lateinit var newArrayList : ArrayList<Movie>


    // variables of the movie
    lateinit var image : Array<Int>
    lateinit var title : Array<String>
    lateinit var description : Array<String>
    lateinit var genres : Array<String>
    lateinit var runningTime : Array<String>
    lateinit var movieSeatsRemaining: Array<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Array that displays all the images
        image = arrayOf(
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
        description = arrayOf(
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
        runningTime = arrayOf(
            getString(R.string.movie_running_time_1),
            getString(R.string.movie_running_time_2),
            getString(R.string.movie_running_time_3),
            getString(R.string.movie_running_time_4),
            getString(R.string.movie_running_time_5)
        )

        movieSeatsRemaining = arrayOf(
            (0..15).random(),
            (0..15).random(),
            (0..15).random(),
            (0..15).random(),
            (0..15).random(),
            (0..15).random()
        )

        newRecycleView = findViewById(R.id.recycleView)
        newRecycleView.layoutManager = LinearLayoutManager(this)
        newRecycleView.setHasFixedSize(true)

        newArrayList = arrayListOf<Movie>()
        getUserdata()

    }

    // Method for running all contents of the array
    private fun getUserdata() {
        for (i in image.indices){
            val news = Movie(image[i], title[i], description[i], genres[i], runningTime[i], movieSeatsRemaining[i])
            newArrayList.add(news)
        }


        // This function gets the item clicked
        val adapter = MovieAdapter(newArrayList)
        newRecycleView.adapter = adapter


        adapter.setOnItemClickListener(object : MovieAdapter.OnItemClickListener {
            override fun onItemClick(position: Int){

            // This line attaches all content to intent, and then starts the new activity with it all
            val intent = Intent(this@MainActivity,MovieActivity::class.java)
                intent.putExtra("image",newArrayList[position].titleImage)
                intent.putExtra("title",newArrayList[position].title)
                intent.putExtra("description",newArrayList[position].description)
                intent.putExtra("genres",newArrayList[position].genres)
                intent.putExtra("runningTime",newArrayList[position].runningTime)
                intent.putExtra("seatsRemaining",newArrayList[position].movieSeatsRemaining)

            startActivity(intent)

            }
        })


//        FONTE: https://github.com/foxandroid/RecylerViewKOtlin/blob/master/app/src/main/java/com/example/recylerviewkotlin/MainActivity.kt

    }
}