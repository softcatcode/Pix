package com.example.pix.domain.usecase

import com.example.pix.domain.entity.Picture
import com.example.pix.domain.entity.PictureSize
import com.example.pix.domain.interfaces.PicturesRepository
import javax.inject.Inject

class TransformPictureSizeUseCase @Inject constructor(
    private val repository: PicturesRepository
) {
    operator fun invoke(
        picture: Picture,
        size: PictureSize
    ) = repository.transformPictureSize(picture, size)
}