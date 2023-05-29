package com.example.homework2.presentation.screen.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.homework2.R
import com.example.homework2.presentation.ui.custom.CustomTheme
import com.example.homework2.presentation.ui.custom.FilmsFontFamily
import com.example.homework2.presentation.ui.custom.FilmsStyle
import com.example.homework2.presentation.ui.custom.blueDarkPalette
import com.example.homework2.presentation.ui.custom.blueLightPalette
import com.example.homework2.presentation.ui.custom.pinkDarkPalette
import com.example.homework2.presentation.ui.custom.pinkLightPalette
import com.example.homework2.presentation.ui.custom.violetDarkPalette
import com.example.homework2.presentation.ui.custom.violetLightPalette

@Suppress("FunctionNaming", "LongMethod")
@Composable
fun SettingsScreen(
    navController: NavController,
) {
    val settingsEventBus = LocalSettingsEventBus.current
    val currentSettings = settingsEventBus.currentSettings.collectAsState().value

    Surface(color = CustomTheme.colors.primaryBackground) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(
                    rememberScrollState()
                )
        ) {
            TopAppBar(
                backgroundColor = CustomTheme.colors.primaryBackground,
                elevation = 8.dp
            ) {
                Text(
                    modifier = Modifier
                        .weight(1f),
                    text = stringResource(id = R.string.screen_settings),
                    color = CustomTheme.colors.primaryText,
                    style = CustomTheme.typography.toolbar
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = "Dark Theme",
                    color = CustomTheme.colors.primaryText,
                    style = CustomTheme.typography.body
                )
                Checkbox(
                    checked = currentSettings.isDarkMode, onCheckedChange = {
                        settingsEventBus.updateDarkMode(!currentSettings.isDarkMode)
                    },
                    colors = CheckboxDefaults.colors(
                        checkedColor = CustomTheme.colors.tintColor,
                        uncheckedColor = CustomTheme.colors.secondaryText
                    )
                )
            }


            Divider(
                thickness = 0.5.dp,
                color = CustomTheme.colors.secondaryText.copy(
                    alpha = 0.3f
                )
            )

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                elevation = 8.dp,
                backgroundColor = CustomTheme.colors.secondaryBackground
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Font family",
                        color = CustomTheme.colors.secondaryText,
                        fontSize = 25.sp
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Card(
                            modifier = Modifier.weight(1f),
                            backgroundColor = CustomTheme.colors.primaryBackground
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(horizontal = 8.dp),
                                    text = "Default",
                                    color = CustomTheme.colors.primaryText,
                                    style = CustomTheme.typography.body
                                )
                                Checkbox(
                                    checked = currentSettings.fontFamily == FilmsFontFamily.Default,
                                    onCheckedChange = {
                                        settingsEventBus.updateFontFamily(FilmsFontFamily.Default)
                                    },
                                    colors = CheckboxDefaults.colors(
                                        checkedColor = CustomTheme.colors.tintColor,
                                        uncheckedColor = CustomTheme.colors.secondaryText
                                    )
                                )
                            }
                        }

                        Spacer(modifier = Modifier.width(8.dp))

                        Card(
                            modifier = Modifier.weight(1f),
                            backgroundColor = CustomTheme.colors.primaryBackground
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(horizontal = 8.dp),
                                    text = "Serif",
                                    color = CustomTheme.colors.primaryText,
                                    style = CustomTheme.typography.body
                                )
                                Checkbox(
                                    checked = currentSettings.fontFamily == FilmsFontFamily.Serif,
                                    onCheckedChange = {
                                        settingsEventBus.updateFontFamily(FilmsFontFamily.Serif)
                                    },
                                    colors = CheckboxDefaults.colors(
                                        checkedColor = CustomTheme.colors.tintColor,
                                        uncheckedColor = CustomTheme.colors.secondaryText
                                    )
                                )
                            }
                        }

                        Spacer(modifier = Modifier.width(8.dp))

                        Card(
                            modifier = Modifier.weight(1f),
                            backgroundColor = CustomTheme.colors.primaryBackground
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(horizontal = 8.dp),
                                    text = "Monospace",
                                    color = CustomTheme.colors.primaryText,
                                    style = CustomTheme.typography.body
                                )
                                Checkbox(
                                    checked = currentSettings.fontFamily == FilmsFontFamily.Monospace,
                                    onCheckedChange = {
                                        settingsEventBus.updateFontFamily(FilmsFontFamily.Monospace)
                                    },
                                    colors = CheckboxDefaults.colors(
                                        checkedColor = CustomTheme.colors.tintColor,
                                        uncheckedColor = CustomTheme.colors.secondaryText
                                    )
                                )
                            }
                        }
                    }
                }
            }

            Divider(
                thickness = 0.5.dp,
                color = CustomTheme.colors.secondaryText.copy(
                    alpha = 0.3f
                )
            )

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                elevation = 8.dp,
                backgroundColor = CustomTheme.colors.secondaryBackground,
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Tint color",
                        color = CustomTheme.colors.secondaryText,
                        fontSize = 25.sp
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        ColorCard(color = if (currentSettings.isDarkMode) violetDarkPalette.tintColor
                        else violetLightPalette.tintColor,
                            onClick = {
                                settingsEventBus.updateStyle(FilmsStyle.Violet)
                            })
                        ColorCard(color = if (currentSettings.isDarkMode) pinkDarkPalette.tintColor
                        else pinkLightPalette.tintColor,
                            onClick = {
                                settingsEventBus.updateStyle(FilmsStyle.Pink)
                            })
                        ColorCard(
                            color = if (currentSettings.isDarkMode) blueDarkPalette.tintColor
                            else blueLightPalette.tintColor,
                            onClick = {
                                settingsEventBus.updateStyle(FilmsStyle.Blue)
                            })
                    }
                }
            }


        }
    }
}

@Suppress("FunctionNaming")
@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun ColorCard(color: Color, onClick: () -> Unit) {
    Card(
        onClick = { onClick() },
        modifier = Modifier
            .size(56.dp, 56.dp),
        backgroundColor = color,
        elevation = 5.dp,
    ) {}
}
