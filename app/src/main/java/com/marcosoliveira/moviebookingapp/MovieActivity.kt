package com.marcosoliveira.moviebookingapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.snackbar.Snackbar.make
import kotlinx.android.synthetic.main.activity_movie.*

class MovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        // variables that belongs to the second screen
        val imageSecondScreen : ImageView = findViewById(R.id.image_second_screen)
        val titleSecondScreen : TextView = findViewById(R.id.title_second_screen)
        val descriptionSecondScreen : TextView = findViewById(R.id.description_second_screen)
        val starringSecondScreen : TextView = findViewById(R.id.starring_second_screen)
        val runningTimeSecondScreen : TextView = findViewById(R.id.running_time_second_screen)
        val seatsRemainingSecondScreen : TextView = findViewById(R.id.seats_remaining_second_screen)


        val bundle : Bundle?= intent.extras



        // variables of the Main Activity
        val image = bundle!!.getInt("image")
        val title = bundle!!.getString("title")
        val description = bundle!!.getString("description")
        val starring = bundle!!.getString("genres")
        val runningTime = bundle!!.getString("runningTime")
        val seatsRemaining = bundle!!.getInt("seatsRemaining")


        // connecting the variables main screen second screen
        imageSecondScreen.setImageResource(image)
        titleSecondScreen.text = title
        descriptionSecondScreen.text = description
        starringSecondScreen.text = starring
        runningTimeSecondScreen.text = runningTime
        seatsRemainingSecondScreen.text = seatsRemaining.toString()



        // btn book with success
        val contextView  = findViewById<Button>(R.id.btn_book_now)
        contextView.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Seats booked with success", Toast.LENGTH_LONG).show()
        }

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