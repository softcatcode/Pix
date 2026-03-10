package com.example.pix.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.pix.domain.entity.Picture
import com.example.pix.presentation.navigation.CustomNavTypes.PictureNavType
import com.example.pix.presentation.pictureView.PictureViewScreen
import com.example.pix.presentation.picturesGrid.PictureGridScreenContent
import com.example.pix.presentation.ui.elements.MainScaffold
import kotlin.reflect.typeOf

private fun NavGraphBuilder.pictureGridScreen(
    navController: NavHostController,
    paddings: PaddingValues,
) {
    composable<Screen.PictureGrid> {
        val args = it.toRoute<Screen.PictureGrid>()
        PictureGridScreenContent(
            args.query,
            pictureNavigation = { picture ->
                navController.navigate(Screen.PictureView(picture))
            },
            paddings = paddings
        )
    }
}

private fun NavGraphBuilder.pictureView(
    paddings: PaddingValues,
) {
    composable<Screen.PictureView>(
        typeMap = mapOf(typeOf<Picture>() to PictureNavType)
    ) {
        val args = it.toRoute<Screen.PictureView>()
        PictureViewScreen(
            initialPicture = args.picture,
            paddings = paddings
        )
    }
}

@Composable
fun FlickrNavigationHost() {
    val navController = rememberNavController()
    MainScaffold(
        onBackPressed = { navController.popBackStack() },
    ) { paddings ->
        NavHost(
            navController = navController,
            startDestination = Screen.PictureGrid("cats")
        ) {
            pictureGridScreen(navController, paddings)
            pictureView(paddings)
        }
    }
}

