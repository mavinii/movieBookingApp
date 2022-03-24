package com.marcosoliveira.moviebookingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MovieActivity : AppCompatActivity() {

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
        setContentView(R.layout.activity_movie)
    }
}