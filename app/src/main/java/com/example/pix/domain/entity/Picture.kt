package com.example.pix.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Picture(
    val url: String,
    val title: String,
): Parcelable