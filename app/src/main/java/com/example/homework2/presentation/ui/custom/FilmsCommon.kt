package com.example.homework2.presentation.ui.custom

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

data class FilmsColors(
    val primaryText: Color,
    val primaryBackground: Color,
    val secondaryText: Color,
    val secondaryBackground: Color,
    val tintColor: Color,
    val controlColor: Color,
    val errorColor: Color,
)

data class FilmsTypography(
    val heading: TextStyle,
    val body: TextStyle,
    val toolbar: TextStyle,
    val caption: TextStyle
)

data class FilmsImages(
    val id: Int,
    val contentDesc: String
)

object FilmsTheme {
    val colors: FilmsColors
        @Composable
        get() = LocalFilmsColors.current

    val typography: FilmsTypography
        @Composable
        get() = LocalFilmsTypography.current
}

enum class FilmsStyle {
    Purple, Orange, Blue, Red, Green, Pink, Violet
}

enum class FilmsSize {
    Small, Medium, Big
}

enum class FilmsFontFamily {
    Default, Serif, Monospace,
}

val LocalFilmsColors = staticCompositionLocalOf<FilmsColors> {
    error("No colors provided")
}

val LocalFilmsTypography = staticCompositionLocalOf<FilmsTypography> {
    error("No font provided")
}
