package com.example.homework2.presentation.screen.stub

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.homework2.R
import com.example.homework2.presentation.ui.custom.CustomTheme

@Suppress("FunctionNaming")
@Composable
fun StubScreen(
    navController: NavController,
) {
    MainContent()
}

@Suppress("FunctionNaming")
@Composable
fun MainContent() {
    Surface(
        color = CustomTheme.colors.primaryBackground,
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            TopAppBar(
                backgroundColor = CustomTheme.colors.secondaryBackground,
                elevation = 8.dp
            ) {
                Text(
                    modifier = Modifier
                        .weight(1f),
                    text = stringResource(id = R.string.screen_stub),
                    color = CustomTheme.colors.primaryText,
                    style = CustomTheme.typography.toolbar
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                val context = LocalContext.current
                val inputStream = context.resources.openRawResource(R.raw.home)
                val bitmap = BitmapFactory.decodeStream(inputStream)
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .height(300.dp),
                ) {
                    Image(
                        bitmap = bitmap.asImageBitmap(),
                        contentDescription = "My Image",
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}
