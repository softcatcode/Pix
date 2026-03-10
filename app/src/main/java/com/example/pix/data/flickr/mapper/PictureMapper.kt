package com.example.pix.data.flickr.mapper

import com.example.pix.data.flickr.dto.PhotoDto
import com.example.pix.domain.entity.Picture
import com.example.pix.domain.entity.PictureSize

// https://www.flickr.com/services/api/misc.urls.html

fun quality(size: PictureSize) = when (size) {
    PictureSize.Small -> "m"
    PictureSize.Big -> "b"
}

fun PhotoDto.toEntity(size: PictureSize) = Picture(
    title = title,
    url = "https://live.staticflickr.com/$server/${id}_${secret}_${quality(size)}.jpg"
)