package com.example.pix.presentation.pictureView

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pix.domain.entity.Picture
import com.example.pix.domain.entity.PictureSize
import com.example.pix.domain.usecase.TransformPictureSizeUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class PictureViewModel @Inject constructor(
    private val picture: Picture,
    private val transformPictureSizeUseCase: TransformPictureSizeUseCase
): ViewModel() {

    private val _state = MutableLiveData<PictureViewScreenState>(PictureViewScreenState.Initial)
    val state: LiveData<PictureViewScreenState>
        get() = _state

    init {
        loadBigPicture()
    }

    private fun loadBigPicture() {
        viewModelScope.launch {
            _state.value = PictureViewScreenState.Content(
                picture = transformPictureSizeUseCase(picture, PictureSize.Big)
            )
        }
    }
}