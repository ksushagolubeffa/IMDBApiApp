package com.example.homework2.presentation.screen.settings

import com.example.homework2.presentation.ui.custom.FilmsFontFamily
import com.example.homework2.presentation.ui.custom.FilmsSize
import com.example.homework2.presentation.ui.custom.FilmsStyle

data class CurrentSettings(
    val isDarkMode: Boolean,
    val textSize: FilmsSize,
    val paddingSize: FilmsSize,
    val style: FilmsStyle,
    val fontFamily: FilmsFontFamily,
)
