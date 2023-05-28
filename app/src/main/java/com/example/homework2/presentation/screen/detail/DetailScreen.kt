package com.example.homework2.presentation.screen.detail

import coil.compose.AsyncImage
import com.example.homework2.presentation.ui.custom.CustomTheme
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.homework2.R
import com.example.homework2.domain.model.DetailModel
import org.koin.androidx.compose.koinViewModel

@Suppress("FunctionNaming")
@Composable
fun DetailScreen(
    navController: NavController,
    viewModel: DetailViewModel = koinViewModel(),
    id: String?,
) {

    val state = viewModel.state.collectAsStateWithLifecycle()
    id?.let {
        viewModel.event(DetailEvent.Init(id))
    }
    MainContent(
        viewState = state.value,
        eventHandler = viewModel::event,
        navController = navController
    )
}

@Suppress("FunctionNaming")
@Composable
fun MainContent(
    viewState: DetailViewState,
    eventHandler: (DetailEvent) -> Unit,
    navController: NavController
) {
    Surface(
        color = CustomTheme.colors.primaryBackground,
    )
    {
        Column(modifier = Modifier.fillMaxSize()) {
            TopAppBar(
                backgroundColor = CustomTheme.colors.secondaryBackground,
                elevation = 8.dp
            ) {
                Text(
                    modifier = Modifier
                        .weight(1f),
                    text = stringResource(id = R.string.screen_detail),
                    color = CustomTheme.colors.primaryText,
                    style = CustomTheme.typography.toolbar,
                    fontSize = 20.sp
                )
            }
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            }
            viewState.detailModel?.also {
                FilmDetails(detailModel = it) {
                    eventHandler.invoke(DetailEvent.OnClick)
                }
            }

        }
    }
}

@Suppress("FunctionNaming", "LongMethod")
@Composable
private fun FilmDetails(detailModel: DetailModel, onItemClick: () -> Unit) {
    Spacer(modifier = Modifier.height(4.dp))
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
        backgroundColor = CustomTheme.colors.secondaryBackground,
    )
    {
        AsyncImage(
            model = detailModel.image!!,
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp),
        )
        Spacer(
            modifier = Modifier.height(8.dp)
        )
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = detailModel.title!!,
                style = CustomTheme.typography.body,
                color = CustomTheme.colors.primaryText,
                fontSize = 24.sp
            )
            Text(
                text = detailModel.year!!,
                style = CustomTheme.typography.body,
                color = CustomTheme.colors.primaryText,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row {
                Text(
                    text = "Genres: ",
                    color = CustomTheme.colors.tintColor,
                    textAlign = TextAlign.Start
                )
                Text(
                    text = detailModel.genres!!,
                    color = CustomTheme.colors.secondaryText,
                    modifier = Modifier
                        .clickable {
                            onItemClick.invoke()
                        }
                        .alignByBaseline()
                )
            }
            Row {
                Text(
                    text = "Countries: ",
                    color = CustomTheme.colors.tintColor,
                    textAlign = TextAlign.Start
                )
                Text(
                    text = detailModel.countries!!,
                    color = CustomTheme.colors.secondaryText,
                    modifier = Modifier
                        .clickable {
                            onItemClick.invoke()
                        }
                        .alignByBaseline()
                )
            }
            Row {
                Text(
                    text = "Companies: ",
                    color = CustomTheme.colors.tintColor,
                    textAlign = TextAlign.Start
                )
                Text(
                    text = detailModel.companies!!,
                    color = CustomTheme.colors.secondaryText,
                    modifier = Modifier
                        .clickable {
                            onItemClick.invoke()
                        }
                        .alignByBaseline()
                )
            }
            Row {
                Text(
                    text = "Director: ",
                    color = CustomTheme.colors.tintColor,
                    textAlign = TextAlign.Start
                )
                Text(
                    text = detailModel.directors!!,
                    color = CustomTheme.colors.secondaryText,
                    modifier = Modifier
                        .clickable {
                            onItemClick.invoke()
                        }
                        .alignByBaseline()
                )
            }
            Row {
                Text(
                    text = "Time: ",
                    color = CustomTheme.colors.tintColor,
                    textAlign = TextAlign.Start
                )
                Text(
                    text = detailModel.time!!,
                    color = CustomTheme.colors.secondaryText,
                    modifier = Modifier
                        .clickable {
                            onItemClick.invoke()
                        }
                        .alignByBaseline()
                )
            }
            Row {
                Text(
                    text = "IMDB rating: ",
                    color = CustomTheme.colors.tintColor,
                    textAlign = TextAlign.Start
                )
                Text(
                    text = detailModel.imdb!!,
                    color = CustomTheme.colors.secondaryText,
                    modifier = Modifier
                        .clickable {
                            onItemClick.invoke()
                        }
                        .alignByBaseline()
                )
            }
            Row {
                Text(
                    text = "World fees: ",
                    color = CustomTheme.colors.tintColor,
                    textAlign = TextAlign.Start
                )
                Text(
                    text = detailModel.worldMoney!!,
                    color = CustomTheme.colors.secondaryText,
                    modifier = Modifier
                        .clickable {
                            onItemClick.invoke()
                        }
                        .alignByBaseline()
                )
            }
            Spacer(modifier = Modifier.height(7.dp))
            Text(
                text = detailModel.description!!,
                style = CustomTheme.typography.body,
                color = CustomTheme.colors.secondaryText
            )
        }
    }
}
