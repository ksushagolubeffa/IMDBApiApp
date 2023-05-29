package com.example.homework2.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import com.example.homework2.presentation.navigation.FilmsNavHost
import com.example.homework2.presentation.screen.settings.LocalSettingsEventBus
import com.example.homework2.presentation.screen.settings.SettingsEventBus
import com.example.homework2.presentation.ui.custom.CustomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val settingsEventBus = remember { SettingsEventBus() }
            val currentSettings = settingsEventBus.currentSettings.collectAsState().value

            CustomTheme(
                style = currentSettings.style,
                textSize = currentSettings.textSize,
                paddingSize = currentSettings.paddingSize,
                fontFamily = currentSettings.fontFamily,
                darkTheme = currentSettings.isDarkMode,
            ) {
                CompositionLocalProvider(
                    LocalSettingsEventBus provides settingsEventBus
                ) {
                    FilmsNavHost()
                }
            }
        }
    }
}
