package com.example.homework2.data

import android.util.Log
import com.example.homework2.data.datasourse.FilmAPI
import com.example.homework2.data.mapping.toFilmInfo
import com.example.homework2.data.mapping.toFilmList
import com.example.homework2.domain.model.DetailModel
import com.example.homework2.domain.model.FilmList
import com.example.homework2.domain.repository.FilmRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FilmRepositoryImpl(private val api: FilmAPI) : FilmRepository {

    override suspend fun getFilm(id: String): DetailModel {
        Log.e("Repository1", "try to get info")
        val value = api.getFilm(id)
        Log.e("Repository2", value.title)
        val value1 = value.toFilmInfo()
        Log.e("Repository3", value1.title!!)
        return value1
    }

    override suspend fun getPopularFilms(): Flow<List<FilmList>> =
        flow {
            emit(
                api.getBestFilms().toFilmList()
            )
        }
}
