package com.marcosoliveira.moviebookingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var newRecycleView : RecyclerView
    private lateinit var newArrayList : ArrayList<Movie>
    lateinit var imageId : Array<Int>
    lateinit var title : Array<String>
    lateinit var descrition : Array<String>
    lateinit var starring : Array<String>
    lateinit var running_time_min : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // An Array that display all the imgs
        imageId = arrayOf(
            R.drawable.fantastic_beasts_the_secrets_of_bumbledore_poster,
            R.drawable.ambulance_poster,
            R.drawable.sonic_2_poster,
            R.drawable.the_batmain_poster,
            R.drawable.uncharted_poster
        )

        // An Array that display all the titles
        title = arrayOf(
            "Secrets of Dumbledore",
            "Ambulance",
            "Sonic the Hedgehog",
            "The Batman",
            "Uncharted"
        )

        // An Array that display all the descriptions
        descrition = arrayOf(
            "Unable to stop the powerful Dark wizard Gellert Grindelwald alone...",
            "Over one day across the streets of L.A., three lives will change forever.",
            "After settling in Green Hills, Sonic is eager to prove he has what it...",
            "From Warner Bros. Pictures comes \"The Batman,\" with director Matt...",
            "Street-smart Nathan Drake (Tom Holland) is recruited by seasoned..."
        )

        // An Array that display all the starring
        starring = arrayOf(
            "Loren",
            "Loren",
            "Loren",
            "Loren",
            "Loren"
        )

        // An Array that display all the starring
        running_time_min = arrayOf(
            "1Hr 56mins",
            "1Hr 56mins",
            "1Hr 56mins",
            "1Hr 56mins",
            "1Hr 56mins"
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
            val news = Movie(imageId[i], title[i], descrition[i], starring[i], running_time_min[i])
            newArrayList.add(news)
        }

        newRecycleView.adapter = MovieAdapter(newArrayList)

    }
}