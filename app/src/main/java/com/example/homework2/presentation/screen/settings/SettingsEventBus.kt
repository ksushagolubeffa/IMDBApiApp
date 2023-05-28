package com.example.homework2.presentation.screen.settings

import androidx.compose.runtime.staticCompositionLocalOf
import com.example.homework2.presentation.ui.custom.FilmsFontFamily
import com.example.homework2.presentation.ui.custom.FilmsSize
import com.example.homework2.presentation.ui.custom.FilmsStyle
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SettingsEventBus {

    private val _currentSettings: MutableStateFlow<CurrentSettings> = MutableStateFlow(
        CurrentSettings(
            isDarkMode = true,
            style = FilmsStyle.Violet,
            textSize = FilmsSize.Medium,
            paddingSize = FilmsSize.Medium,
            fontFamily = FilmsFontFamily.Default
        )
    )
    val currentSettings: StateFlow<CurrentSettings> = _currentSettings

    fun updateDarkMode(isDarkMode: Boolean) {
        _currentSettings.value = _currentSettings.value.copy(isDarkMode = isDarkMode)
    }

    fun updateStyle(style: FilmsStyle) {
        _currentSettings.value = _currentSettings.value.copy(style = style)
    }

    fun updateFontFamily(fontFamily: FilmsFontFamily) {
        _currentSettings.value = _currentSettings.value.copy(fontFamily = fontFamily)
    }
}

val LocalSettingsEventBus = staticCompositionLocalOf {
    SettingsEventBus()
}
