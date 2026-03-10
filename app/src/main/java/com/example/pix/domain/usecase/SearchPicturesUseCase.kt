package com.example.pix.domain.usecase

import com.example.pix.domain.entity.PictureSize
import com.example.pix.domain.interfaces.PicturesRepository
import javax.inject.Inject

class SearchPicturesUseCase @Inject constructor(
    private val repository: PicturesRepository
) {
    suspend operator fun invoke(
        query: String,
        page: Int,
        perPage: Int,
        size: PictureSize
    ) = repository.search(query, page, perPage, size)
}