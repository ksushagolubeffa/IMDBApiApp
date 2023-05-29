package com.example.homework2.di

import com.example.homework2.data.FilmRepositoryImpl
import com.example.homework2.data.datasourse.FilmAPI
import com.example.homework2.domain.repository.FilmRepository
import com.example.homework2.domain.usecase.GetFilmListUseCase
import com.example.homework2.domain.usecase.GetFilmUseCase
import org.koin.dsl.module

val filmsModule = module {

    single { provideFilmsRepository(get()) }
    factory { provideGetFilmListUseCase(get()) }
    factory { provideGetFilmUseCase(get()) }
}

private fun provideFilmsRepository(
    filmApi: FilmAPI
): FilmRepository = FilmRepositoryImpl(filmApi)


private fun provideGetFilmUseCase(
    filmRepository: FilmRepository,
): GetFilmUseCase = GetFilmUseCase(filmRepository)

private fun provideGetFilmListUseCase(
    filmRepository: FilmRepository,
): GetFilmListUseCase = GetFilmListUseCase(filmRepository)
