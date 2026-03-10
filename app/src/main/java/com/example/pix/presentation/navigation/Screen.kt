package com.example.pix.presentation.navigation

import com.example.pix.domain.entity.Picture
import kotlinx.serialization.Serializable

sealed interface Screen {

    @Serializable
    data class PictureGrid(
        val query: String
    ): Screen

    @Serializable
    data class PictureView(
        val picture: Picture
    ): Screen
}