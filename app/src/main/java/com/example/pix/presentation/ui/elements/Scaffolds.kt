package com.example.pix.presentation.ui.elements

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.pix.R

/**
 * Все Scaffold'ы, используемые в приложении располагаются в этом файле.
 * Здесь можно усложнять их внешний вид, не делая вёрстку остального дизайна более вложенной.
 * Более того, можно развивать Scaffold для различных экранов независимо друг от друга.
 */

@Composable
fun MainScaffold(
    onBackPressed: () -> Unit = {},
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        topBar = {
            FlickrTopBar(
                title = stringResource(R.string.picture_grid_title),
                onBackPressed = { onBackPressed() }
            )
        }
    ) { paddings ->
        content(paddings)
    }
}


