package com.example.pix.presentation.picturesGrid

import com.example.pix.domain.entity.Picture

sealed interface PictureGridScreenState {

    // Начальное состояние экрана.
    data object Initial: PictureGridScreenState

    // Отображение только ProgressBar.
    data object Loading: PictureGridScreenState

    // Отображается только ошибка загрузки. Ранее загруженных данных нет.
    data class Error(val message: String): PictureGridScreenState

    // Отображается таблица ранее загруженных картинок,
    // ProgressBar после неё, если грузятся следующие картинки, и
    // элемент с ошибкой загрузки следующих картинок (по необходимости).
    data class Content(
        val pictures: List<Picture>,
        val nextLoading: Boolean,
        val errorMessage: String? = null
    ): PictureGridScreenState
}