package com.example.pix.presentation.pictureView

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.pix.domain.entity.Picture
import com.example.pix.presentation.extensions.getPictureViewComponent

@Composable
private fun PictureViewContent(
    picture: Picture,
    paddings: PaddingValues,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddings),
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = picture.url,
            contentDescription = picture.title,
            contentScale = ContentScale.FillBounds
        )
    }
}

@Composable
fun PictureViewScreen(
    initialPicture: Picture,
    paddings: PaddingValues
) {
    /**
     * PictureViewModel может реализовывать различные преобразования объекта Picture.
     * Следовательно, PictureViewModel должен принимать Picture в конструктор.
     * А сделать инъекцию данной зависимости можно только на этапе выполнения.
     * Для этого использован Subcomponent из Dagger'а.
     */
    val component = getPictureViewComponent(initialPicture)
    val viewModel: PictureViewModel = viewModel(factory = component.getViewModelFactory())
    val model = viewModel.state.observeAsState(initial = PictureViewScreenState.Initial)

    when (val state = model.value) {

        is PictureViewScreenState.Content -> {
            PictureViewContent(
                picture = state.picture, // картинка с увиличенным разрешением
                paddings = paddings
            )
        }

        PictureViewScreenState.Initial -> {}
    }
}