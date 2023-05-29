package com.example.homework2.domain.repository

import com.example.homework2.domain.model.DetailModel
import com.example.homework2.domain.model.FilmList
import kotlinx.coroutines.flow.Flow

interface FilmRepository {
    suspend fun getFilm(id: String): DetailModel
    suspend fun getPopularFilms(): Flow<List<FilmList>>
}
