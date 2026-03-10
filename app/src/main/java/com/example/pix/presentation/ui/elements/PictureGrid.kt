package com.example.pix.presentation.ui.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.pix.domain.entity.Picture
import kotlinx.coroutines.delay

private val defaultPictureList: List<Picture> = listOf(
    Picture(title = "turtle", url = "https://i.pinimg.com/736x/ad/28/d8/ad28d8ff20f59efe1569399698d5661d.jpg"),
    Picture(title = "owl", url = "https://i.pinimg.com/originals/eb/e1/57/ebe157c34830957a4a1952c955e8bd20.jpg"),
    Picture(title = "butterfly", url = "https://i.pinimg.com/originals/ce/63/a9/ce63a92d29d42cbe6889feb199392ce8.png"),
    Picture(title = "tiger", url = "https://greenwildscreen.com/wp-content/uploads/2022/01/tigr11.png"),
    Picture(title = "cat", url = "https://img.goodfon.com/original/960x854/9/bf/kot-koshka-cvety-trava-lezhit.jpg"),
)

@Composable
@Preview
fun PictureGrid(
    modifier: Modifier = Modifier,
    pictures: List<Picture> = defaultPictureList,
    nextLoading: Boolean = true,
    onPictureClick: (Picture) -> Unit = {},
    onLoadNext: () -> Unit = {}
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp
    val picturesInRow = 3
    val paddingSize = 5
    val imgSize = screenWidth / picturesInRow - paddingSize

    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.FixedSize(imgSize.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalArrangement = Arrangement.spacedBy(3.dp)
    ) {
        items(items = pictures) { img ->
            Card(
                modifier = Modifier
                    .size(imgSize.dp)
                    .padding(2.dp),
                onClick = { onPictureClick(img) },
                shape = RectangleShape
            ) {
                AsyncImage(
                    modifier = Modifier.fillMaxSize(),
                    model = img.url,
                    contentDescription = img.title,
                    contentScale = ContentScale.FillBounds
                )
            }
        }
        item {
            if (nextLoading) {
                Box(
                    modifier = Modifier.size(imgSize.dp),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(48.dp),
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            } else {
                LaunchedEffect(pictures.size) {
                    delay(500)
                    onLoadNext()
                }
            }
        }
    }
}