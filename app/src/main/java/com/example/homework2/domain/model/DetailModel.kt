package com.example.homework2.domain.model

import com.example.homework2.data.datasourse.response.SimilarShort

data class DetailModel(
    val id: String? = null,
    val title: String? = null,
    val year: String? = null,
    val image: String? = null,
    val time: String? = null,
    val description: String? = null,
    val directors: String? = null,
    val stars: String? = null,
    val companies: String? = null,
    val genres: String? = null,
    val countries: String? = null,
    val budget: String? = null,
    val imdb: String? = null,
    val usaMoney: String? = null,
    val worldMoney: String? = null,
    val tagline: String? = null,
    val keywordList: List<String>,
    val similarList: List<SimilarShort>,
)
