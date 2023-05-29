package com.example.homework2.presentation.screen.list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.getValue
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material3.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.homework2.presentation.navigation.Screen
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.homework2.R
import com.example.homework2.domain.model.FilmList
import com.example.homework2.presentation.ui.custom.CustomTheme
import org.koin.androidx.compose.koinViewModel

@Suppress("FunctionNaming")
@Composable
fun ListScreen(
    navController: NavController,
    viewModel: ListViewModel = koinViewModel(),
) {

    val state = viewModel.state.collectAsStateWithLifecycle()
    val action by viewModel.action.collectAsStateWithLifecycle(null)
    MainContent(
        viewState = state.value,
        eventHandler = viewModel::event,
    )

    ListScreenActions(
        navController = navController,
        viewAction = action
    )
}

@Suppress("FunctionNaming")
@Composable
fun MainContent(
    viewState: ListViewState,
    eventHandler: (ListEvent) -> Unit,
) {
    Column {
        TopAppBar(
            backgroundColor = CustomTheme.colors.primaryBackground,
            elevation = 8.dp
        ) {
            Text(
                modifier = Modifier
                    .weight(1f),
                text = stringResource(id = R.string.screen_list),
                color = CustomTheme.colors.primaryText,
                style = CustomTheme.typography.toolbar
            )
        }
        LazyColumnSample(viewState, eventHandler)
    }
}

@Suppress("FunctionNaming")
@Composable
fun LazyColumnSample(
    viewState: ListViewState,
    eventHandler: (ListEvent) -> Unit,
) {
    val filmList by viewState.filmListModel.collectAsState(initial = emptyList())
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(CustomTheme.colors.primaryBackground),
    ) {
        items(filmList.size) { index ->
            val item = filmList[index]
            MyListItem(detailModel = item) { item ->
                eventHandler.invoke(ListEvent.onItemClick(item))
            }
        }
    }
}

@Suppress("FunctionNaming")
@Composable
private fun MyListItem(
    detailModel: FilmList,
    onClick: (FilmList) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick.invoke(detailModel)
            }
            .padding(8.dp)
            .background(
                color = CustomTheme.colors.secondaryBackground,
            )
            .padding(16.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp),
        ) {
            AsyncImage(
                model = detailModel.image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()

            )
        }
        Spacer(
            modifier = Modifier.height(8.dp)
        )
        Text(
            text = detailModel.title,
            style = CustomTheme.typography.body,
            color = CustomTheme.colors.primaryText,
            fontSize = 20.sp
        )
        Spacer(
            modifier = Modifier.height(8.dp)
        )
        Text(
            text = detailModel.year,
            style = CustomTheme.typography.body,
            color = CustomTheme.colors.primaryText,
            fontSize = 20.sp
        )

    }
}

@Suppress("FunctionNaming")
@Composable
private fun ListScreenActions(
    navController: NavController,
    viewAction: ListAction?,
) {
    LaunchedEffect(viewAction) {
        when (viewAction) {
            null -> Unit
            is ListAction.Navigate -> {
                navController.navigate(Screen.Detail.route + "/${viewAction.id}")
            }
        }
    }
}
