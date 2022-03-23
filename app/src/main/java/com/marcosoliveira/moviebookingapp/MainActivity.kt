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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageId = arrayOf(
            R.drawable.fantastic_beasts_the_secrets_of_bumbledore_poster,
            R.drawable.ambulance_poster,
            R.drawable.sonic_2_poster,
            R.drawable.the_batmain_poster,
            R.drawable.uncharted_poster
        )

        title = arrayOf(
            "Fantastic Beasts: The Secrets of Dumbledore",
            "Ambulance",
            "Sonic the Hedgehog",
            "The Batman",
            "Uncharted"
        )

        descrition = arrayOf(
            "Unable to stop the powerful Dark wizard Gellert Grindelwald alone...",
            "Over one day across the streets of L.A., three lives will change forever.",
            "After settling in Green Hills, Sonic is eager to prove he has what it...",
            "From Warner Bros. Pictures comes \"The Batman,\" with director Matt Reeves...",
            "Street-smart Nathan Drake (Tom Holland) is recruited by seasoned treasure..."
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
            val news = Movie(imageId[i], title[i], descrition[i])
            newArrayList.add(news)
        }

        newRecycleView.adapter = MovieAdapter(newArrayList)

    }
}