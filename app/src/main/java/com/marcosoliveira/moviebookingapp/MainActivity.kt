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
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background
        )

        title = arrayOf(
            "Title 1",
            "Title 2",
            "Title 3",
            "Title 4",
            "Title 5"
        )

        descrition = arrayOf(
            "Description 1",
            "Description 2",
            "Description 3",
            "Description 4",
            "Description 5"
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