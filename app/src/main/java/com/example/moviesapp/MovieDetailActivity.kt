package com.example.moviesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moviesapp.databinding.ActivityMovieDetailBinding
import com.squareup.picasso.Picasso

class MovieDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movie = intent.getParcelableExtra<Movie>("movie")

        movie?.let {
            binding.tvMovieTitle.text = it.title
            binding.tvMovieRating.text = it.rating.toString()
            Picasso.get().load(it.image).into(binding.ivMoviePoster)
            binding.tvMovieYear.text = it.year
            binding.tvMovieDescription.text = it.description
        }
    }
}
