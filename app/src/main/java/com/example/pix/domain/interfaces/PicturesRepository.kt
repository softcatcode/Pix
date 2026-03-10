package com.example.pix.domain.interfaces

import com.example.pix.domain.entity.Picture
import com.example.pix.domain.entity.PictureSize

interface PicturesRepository {
    suspend fun search(
        text: String = "cats",
        page: Int = 1,
        count: Int = 100,
        size: PictureSize
    ): Result<List<Picture>>

    fun transformPictureSize(
        picture: Picture,
        newSize: PictureSize
    ): Picture
}