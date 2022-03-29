package com.marcosoliveira.moviebookingapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.snackbar.Snackbar.make
import kotlinx.android.synthetic.main.activity_movie.*

class MovieActivity : AppCompatActivity() {

    lateinit var movieSeatsRemaining: Array<Int>

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


        // connecting the variables of the main screen with the vars of the second screen
        imageSecondScreen.setImageResource(image)
        titleSecondScreen.text = title
        descriptionSecondScreen.text = description
        starringSecondScreen.text = starring
        runningTimeSecondScreen.text = runningTime
        seatsRemainingSecondScreen.text = seatsRemaining.toString()


        // BTN book now with Toast and a message / tried with SnackBar but could not make that
        // works while taking the user the next screen
        val contextView  = findViewById<Button>(R.id.btn_book_now)
        contextView.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "SEATS BOOKED WITH SUCCESS", Toast.LENGTH_LONG).show()
        }

    }

}