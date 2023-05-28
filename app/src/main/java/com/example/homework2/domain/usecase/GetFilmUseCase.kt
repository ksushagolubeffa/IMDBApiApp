package com.example.homework2.domain.usecase

import android.util.Log
import com.example.homework2.domain.model.DetailModel
import com.example.homework2.domain.repository.FilmRepository

class GetFilmUseCase(
    private val repository: FilmRepository,
) {

    suspend operator fun invoke(id: String): DetailModel {
        Log.e("GetFilmUseCase", "try to get")
        return repository.getFilm(id)
    }
}
