package com.example.homework2.di

import com.example.homework2.BuildConfig
import com.example.homework2.BuildConfig.API_ENDPOINT
import com.example.homework2.data.datasourse.FilmAPI
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
//    factory<Interceptor>(named("ApiKey")) {
//        ApiKeyInterceptor()
//    }
    factory<Interceptor>(named("Logging")) {
        HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }
    }
    single { GsonConverterFactory.create() }
    single(qualifier = named("base_url")) { API_ENDPOINT }
    single {
        provideHttpClient(get(named("Logging")))
    }
    single {
        provideRetrofit(
            httpClient = get(),
            gsonFactory = get(),
            baseUrl = get(named("base_url"))
        )
    }
    factory {
        get<Retrofit>().create(FilmAPI::class.java)
    }
}

private fun provideHttpClient(
//    apiKeyInterceptor: Interceptor,
    loggingInterceptor: Interceptor,
): OkHttpClient = OkHttpClient.Builder()
    .addInterceptor(loggingInterceptor)
//    .addInterceptor(apiKeyInterceptor)
    .connectTimeout(10L, TimeUnit.SECONDS)
    .build()

private fun provideRetrofit(
    httpClient: OkHttpClient,
    gsonFactory: GsonConverterFactory,
    baseUrl: String,
): Retrofit = Retrofit.Builder()
    .client(httpClient)
    .baseUrl(baseUrl)
    .addConverterFactory(gsonFactory)
    .build()
