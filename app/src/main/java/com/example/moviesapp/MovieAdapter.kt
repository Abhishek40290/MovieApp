package com.example.moviesapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.databinding.ItemMovieBinding
import com.squareup.picasso.Picasso
import java.util.Locale


class MovieAdapter(
    var movies: List<Movie>,
    private val onItemClick: (Movie) -> Unit,
) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private var fullMovie: List<Movie> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    inner class ViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.tvMovieTitle.text = movie.title
            binding.tvMovieRating.text = movie.rating
            Picasso.get().load(movie.image).into(binding.ivMoviePoster)
            binding.tvMovieDescription.text = movie.description
         //   binding.tvMovieYear.text = movie.year

            binding.root.setOnClickListener {
                onItemClick.invoke(movie)
            }
            binding.root.elevation = 4f
            binding.root.setBackgroundResource(R.drawable.card_background)
        }
    }

    fun filterMovies(query: String) {
        if(fullMovie.isEmpty()){
            fullMovie = movies
        }
        val keywords = query.trim().split("\\s+".toRegex())
        val filteredMovies = fullMovie.filter { movie ->
            val lowercaseQuery = movie.title.toLowerCase(Locale.ROOT)
            keywords.all {keyword ->
                lowercaseQuery.contains(keyword.toLowerCase(Locale.ROOT))
            }

        }
        movies = filteredMovies
        notifyDataSetChanged()
    }
}
