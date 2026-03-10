package com.example.pix.presentation.picturesGrid

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pix.domain.entity.Picture
import com.example.pix.presentation.extensions.getApplicationComponent
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pix.presentation.ui.elements.PictureGrid
import kotlinx.coroutines.delay

@Composable
@Preview
private fun LoadingContent() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(70.dp),
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
@Preview
private fun ErrorContent(
    message: String = "Default error message",
    onRetry: () -> Unit = {},
    paddings: PaddingValues = PaddingValues(0.dp),
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddings),
        contentAlignment = Alignment.Center
    ) {
        OutlinedCard(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .padding(horizontal = 16.dp),
            shape = RoundedCornerShape(5),
            colors = CardDefaults.cardColors().copy(
                containerColor = Color.Transparent
            ),
            border = BorderStroke(2.dp, Color.Black)
        ) {
            Text(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxSize(),
                text = message,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Red
            )
        }
    }
    LaunchedEffect(message) {
        delay(1000)
        onRetry()
    }
}

@Composable
@Preview
private fun PicturesContent(
    pictures: List<Picture> = listOf(),
    nextLoading: Boolean = true,
    errorMessage: String? = "Default error message",
    onLoadNext: () -> Unit = {},
    onPictureClick: (Picture) -> Unit = {},
    paddings: PaddingValues = PaddingValues(0.dp),
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddings)
    ) {
        if (errorMessage != null) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(horizontal = 16.dp),
                text = errorMessage,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Red
            )
        }
        PictureGrid(
            modifier = Modifier.fillMaxSize(),
            pictures = pictures,
            nextLoading = nextLoading,
            onPictureClick = onPictureClick,
            onLoadNext = onLoadNext
        )
    }
}

@Composable
fun PictureGridScreenContent(
    query: String,
    pictureNavigation: (Picture) -> Unit,
    paddings: PaddingValues,
) {
    val component = getApplicationComponent()
    val viewModel: PictureListViewModel = viewModel(factory = component.getViewModelFactory())
    val model = viewModel.state.observeAsState(initial = PictureGridScreenState.Initial)

    when (val state = model.value) {
        PictureGridScreenState.Initial -> {
            viewModel.loadPictures(query)
        }

        PictureGridScreenState.Loading -> {
            LoadingContent()
        }

        is PictureGridScreenState.Error -> {
            ErrorContent(
                message = state.message,
                onRetry = { viewModel.loadPictures(query) },
                paddings
            )
        }

        is PictureGridScreenState.Content -> {
            PicturesContent(
                state.pictures,
                state.nextLoading,
                state.errorMessage,
                onLoadNext = { viewModel.nextPage() },
                onPictureClick = { pictureNavigation(it) },
                paddings = paddings
            )
        }
    }
}