package com.example.moviesapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface MovieApi {
    @GET("/")
    fun getMovies(@Header("X-RapidAPI-Key") apiKey: String): Call<List<Movie>>
}
