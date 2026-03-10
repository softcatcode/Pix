package com.example.pix.data.implementations

import com.example.pix.data.flickr.api.FlickrApi
import com.example.pix.data.flickr.mapper.quality
import com.example.pix.data.flickr.mapper.toEntity
import com.example.pix.domain.entity.Picture
import com.example.pix.domain.entity.PictureSize
import com.example.pix.domain.interfaces.PicturesRepository
import javax.inject.Inject

class FlickrRepository @Inject constructor(
    private val flickrApi: FlickrApi,
): PicturesRepository {

    override suspend fun search(
        text: String,
        page: Int,
        count: Int,
        size: PictureSize
    ): Result<List<Picture>> = runCatching {
        val result = flickrApi.search(text, page, count)
        val photosList = result.photos?.photo.orEmpty()
        photosList.map { it.toEntity(size) }
    }

    override fun transformPictureSize(
        picture: Picture,
        newSize: PictureSize
    ): Picture {
        val index = picture.url.lastIndexOf('_')
        val newUrl: String = if (index == -1)
            picture.url
        else
            picture.url.substring(0, index + 1) + quality(newSize) + ".jpg"
        return Picture(
            title = picture.title,
            url = newUrl
        )
    }
}