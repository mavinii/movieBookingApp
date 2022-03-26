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

        val imageSecondScreen : ImageView = findViewById(R.id.image_second_screen)
        val titleSecondScreen : TextView = findViewById(R.id.title_second_screen)
        val descriptionSecondScreen : TextView = findViewById(R.id.description_second_screen)

        val bundle : Bundle?= intent.extras

        val image = bundle!!.getInt("image")
        val title = bundle!!.getString("title")
        val description = bundle!!.getString("description")

        imageSecondScreen.setImageResource(image)
        titleSecondScreen.text = title
        descriptionSecondScreen.text = description
    }

    //    ERROR FOUND, I WAS TRYING TO EXECUTE THIS CODE OUSIDE OF MY METHOD ONCREATE
//    val imageSecondScreen : ImageView = findViewById(R.id.image_second_screen)
//    val titleSecondScreen : TextView = findViewById(R.id.title_second_screen)
//    val descriptionSecondScreen : TextView = findViewById(R.id.description_second_screen)
//
//    val bundle : Bundle?= intent.extras
//
//    val image = bundle!!.getInt("image")
//    val title = bundle!!.getString("title")
//    val description = bundle!!.getString("description")
//
//    imageSecondScreen.setImageResource(image)
//    titleSecondScreen.text = title
//    descriptionSecondScreen.text = description
}