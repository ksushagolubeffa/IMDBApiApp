package com.example.homework2.data.datasourse

import com.example.homework2.data.datasourse.response.FilmListResponse
import com.example.homework2.data.datasourse.response.FilmResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface FilmAPI {

//    val helper: Helper
//    val filmUrl: String
//        get() = helper.buildUrlList("Title/")

    @GET("https://imdb-api.com/en/API/MostPopularMovies/k_i4yj6il6")
    suspend fun getBestFilms(
//        @Path("filmsUrl") filmsUrl:String = helper.buildUrlList("MostPopularMovies/")
    ): FilmListResponse

    @GET("https://imdb-api.com/en/API/Title/k_i4yj6il6/{id}")
    suspend fun getFilm(
        @Path("id") id: String,
//        @Path("filmUrl") filmUrl:String = helper.buildUrlList("Title/"),
//        @Path("base_url") base_url:String = url,
//        @Path("apiKey") apiKey:String = key
    ): FilmResponse
}
