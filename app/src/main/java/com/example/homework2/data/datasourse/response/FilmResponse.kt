package com.example.homework2.data.datasourse.response

import com.google.gson.annotations.SerializedName

data class FilmResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("year")
    val year: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("runtimeStr")
    val time: String,
    @SerializedName("plot")
    val description: String,
    @SerializedName("directors")
    val directors: String,
    @SerializedName("stars")
    val stars: String,
    @SerializedName("companies")
    val companies: String,
    @SerializedName("genres")
    val genres: String,
    @SerializedName("countries")
    val countries: String,
    @SerializedName("budget")
    val budget: String,
    @SerializedName("imDbRating")
    val imdb: String,
    @SerializedName("grossUSA")
    val usaMoney: String,
    @SerializedName("cumulativeWorldwideGross")
    val worldMoney: String,
    @SerializedName("tagline")
    val tagline: String,
    @SerializedName("keywordList")
    val keywordList: List<String>,
    @SerializedName("similars")
    val similarList: List<SimilarShort>,
)

data class SimilarShort(
    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("imDbRating")
    val imdb: String,
)
