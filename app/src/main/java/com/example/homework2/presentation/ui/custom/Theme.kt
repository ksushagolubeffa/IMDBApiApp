package com.example.homework2.presentation.ui.custom

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.core.view.WindowCompat

@Suppress("FunctionNaming", "LongMethod")
@Composable
fun CustomTheme(
    style: FilmsStyle = FilmsStyle.Purple,
    textSize: FilmsSize = FilmsSize.Medium,
    paddingSize: FilmsSize = FilmsSize.Medium,
    fontFamily: FilmsFontFamily = FilmsFontFamily.Default,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = when {
        darkTheme -> {
            when (style) {
                FilmsStyle.Purple -> purpleDarkPalette
                FilmsStyle.Blue -> blueDarkPalette
                FilmsStyle.Orange -> orangeDarkPalette
                FilmsStyle.Red -> redDarkPalette
                FilmsStyle.Green -> greenDarkPalette
                FilmsStyle.Pink -> pinkDarkPalette
                FilmsStyle.Violet -> violetDarkPalette
            }
        }

        else -> {
            when (style) {
                FilmsStyle.Purple -> purpleLightPalette
                FilmsStyle.Blue -> blueLightPalette
                FilmsStyle.Orange -> orangeLightPalette
                FilmsStyle.Red -> redLightPalette
                FilmsStyle.Violet -> violetLightPalette
                FilmsStyle.Pink -> pinkLightPalette
                FilmsStyle.Green -> greenLightPalette
            }
        }
    }

    val typography = FilmsTypography(
        heading = TextStyle(
            fontFamily = when (fontFamily) {
                FilmsFontFamily.Default -> FontFamily.Default
                FilmsFontFamily.Serif -> FontFamily.Serif
                FilmsFontFamily.Monospace -> FontFamily.Monospace
            },
            fontSize = when (textSize) {
                FilmsSize.Small -> 24.sp
                FilmsSize.Medium -> 28.sp
                FilmsSize.Big -> 32.sp
            },
            fontWeight = FontWeight.Bold
        ),
        body = TextStyle(
            fontFamily = when (fontFamily) {
                FilmsFontFamily.Default -> FontFamily.Default
                FilmsFontFamily.Serif -> FontFamily.Serif
                FilmsFontFamily.Monospace -> FontFamily.Monospace
            },
            fontSize = when (textSize) {
                FilmsSize.Small -> 14.sp
                FilmsSize.Medium -> 16.sp
                FilmsSize.Big -> 18.sp
            },
            fontWeight = FontWeight.Normal
        ),
        toolbar = TextStyle(
            fontFamily = FontFamily.Serif,
            fontSize = when (textSize) {
                FilmsSize.Small -> 14.sp
                FilmsSize.Medium -> 16.sp
                FilmsSize.Big -> 18.sp
            },
            fontWeight = FontWeight.Medium
        ),
        caption = TextStyle(
            fontFamily = when (fontFamily) {
                FilmsFontFamily.Default -> FontFamily.Default
                FilmsFontFamily.Serif -> FontFamily.Serif
                FilmsFontFamily.Monospace -> FontFamily.Monospace
            },
            fontSize = when (textSize) {
                FilmsSize.Small -> 10.sp
                FilmsSize.Medium -> 12.sp
                FilmsSize.Big -> 14.sp
            }
        ),
    )

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colors.primaryBackground.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    CompositionLocalProvider(
        LocalFilmsColors provides colors,
        LocalFilmsTypography provides typography,
        content = content
    )
}
