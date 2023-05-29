package com.example.homework2.presentation.navigation

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.homework2.R
import com.example.homework2.presentation.ui.custom.CustomTheme
import com.example.homework2.presentation.screen.detail.DetailScreen
import com.example.homework2.presentation.screen.list.ListScreen
import com.example.homework2.presentation.screen.settings.SettingsScreen
import com.example.homework2.presentation.screen.stub.StubScreen

@Suppress("FunctionNaming")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilmsNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: Screen = Screen.List,
) {
    val items = listOf(Screen.Stub, Screen.List, Screen.Settings)
    Scaffold(
        bottomBar = {
            BottomNavigation(
                backgroundColor = CustomTheme.colors.tintColor
            ) {

                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                items.forEach { screen ->
                    BottomNavigationItem(
                        label = { Text(stringResource(id = screen.name)) },
                        icon = { Icon(imageVector = screen.icon, contentDescription = null) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = startDestination.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Stub.route) { StubScreen(navController) }
            composable(Screen.List.route) { ListScreen(navController) }
            composable(Screen.Detail.route + "/{id}") { navBackStack ->
                val id = navBackStack.arguments?.getString("id")
                DetailScreen(
                    navController = navController,
                    id = id
                )
            }
            composable(Screen.Settings.route) { SettingsScreen(navController) }
        }
    }
}

sealed class Screen(
    val route: String,
    @StringRes
    val name: Int,
    val icon: ImageVector,
) {
    object Detail : Screen(
        route = "detail",
        name = R.string.screen_detail,
        icon = Icons.Filled.Info
    )

    object List : Screen(
        route = "list",
        name = R.string.screen_list,
        icon = Icons.Filled.Home
    )

    object Settings : Screen(
        route = "settings",
        name = R.string.screen_settings,
        icon = Icons.Filled.Settings,
    )

    object Stub : Screen(
        route = "stub",
        name = R.string.screen_stub,
        icon = Icons.Filled.Home
    )
}
