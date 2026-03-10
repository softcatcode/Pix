package com.example.pix.presentation.pictureView

import com.example.pix.domain.entity.Picture

sealed interface PictureViewScreenState {

    // Начальное состояние экрана.
    data object Initial: PictureViewScreenState

    data class Content(
        val picture: Picture,
    ): PictureViewScreenState
}