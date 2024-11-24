package com.example.lab08

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lab08.databinding.ActivityDetailBinding
import com.google.android.material.snackbar.Snackbar

class DetailActivity : AppCompatActivity() {
    private lateinit var binding:ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        binding.nameTextView.text = intent.getStringExtra("name")
        binding.phoneTextView.text = intent.getStringExtra("phone")
        binding.sizeTextView.text = intent.getStringExtra("size")
        binding.dateTextView.text = intent.getStringExtra("date")
        binding.timeTextView.text = intent.getStringExtra("time")

        binding.sendButton.setOnClickListener {
            binding.ratingTextView.text = binding.ratingBar.rating.toString()

            /* Display Snackbar after user click send button (without button)
            Snackbar.make(view, "Thank you for your rating, we've received it!",
                Snackbar.LENGTH_LONG).show()
                */

            //Display Snackbar after user click send button (with button)
            Snackbar.make(view, "Thank you for your rating, we've received it!",
                Snackbar.LENGTH_LONG).setAction("OK") {
                    println("User pressed OK!")
            }.show()
        }

        }
    }