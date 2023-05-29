package com.example.homework2.domain.usecase

import android.util.Log
import com.example.homework2.domain.model.FilmList
import com.example.homework2.domain.repository.FilmRepository
import kotlinx.coroutines.flow.Flow

class GetFilmListUseCase(
    private val repository: FilmRepository
) {
    suspend operator fun invoke(): Flow<List<FilmList>> {
        Log.e("GetFilmListUseCase", "try to get")
        return repository.getPopularFilms()
    }
}
