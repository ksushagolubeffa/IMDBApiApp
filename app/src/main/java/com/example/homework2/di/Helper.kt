package com.example.homework2.di

import com.example.homework2.BuildConfig

class Helper {
    fun buildUrlList(query: String): String {
        return "${BuildConfig.API_ENDPOINT}$query${BuildConfig.API_KEY}"
    }
}
