package com.example.homework2.data.mapping

import com.example.homework2.data.datasourse.response.FilmListResponse
import com.example.homework2.data.datasourse.response.FilmResponse
import com.example.homework2.data.datasourse.response.ListResponse
import com.example.homework2.domain.model.DetailModel
import com.example.homework2.domain.model.FilmList

fun FilmResponse.toFilmInfo(): DetailModel {
    return DetailModel(
        id = id,
        title = title,
        year = year,
        image = image,
        time = time,
        description = description,
        directors = directors,
        stars = stars,
        companies = companies,
        genres = genres,
        countries = countries,
        budget = budget,
        imdb = imdb,
        usaMoney = usaMoney,
        worldMoney = worldMoney,
        tagline = tagline,
        keywordList = keywordList,
        similarList = similarList,
    )
}

fun ListResponse.toFilmInfo(): FilmList {
    return FilmList(
        id = id,
        title = title,
        year = year,
        image = image,
        rank = rank,
        rankUpDown = rankUpDown,
        fullTitle = fullTitle,
        crew = crew,
        imDbRating = imDbRating,
        imDbRatingCount = imDbRatingCount,
    )
}

fun FilmListResponse.toFilmList(): List<FilmList> {
    val detailModels = mutableListOf<FilmList>()
    this.items.forEach { filmResponse ->
        detailModels.add(filmResponse.toFilmInfo())
    }
    return detailModels
}
