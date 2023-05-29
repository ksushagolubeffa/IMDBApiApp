package com.example.homework2.presentation.ui.custom

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable

object CustomTheme {
    val colors: FilmsColors
        @Composable
        @ReadOnlyComposable
        get() = LocalFilmsColors.current

    val typography: FilmsTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalFilmsTypography.current
}
