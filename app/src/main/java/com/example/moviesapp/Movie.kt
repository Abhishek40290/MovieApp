package com.example.moviesapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val id: String,
    val title: String,
    val rating: String,
    val image: String,
    val description: String,
    val year: String,
    val thumbnail: String
) : Parcelable
