package com.example.pix.presentation.navigation

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavType
import com.example.pix.domain.entity.Picture
import kotlinx.serialization.json.Json

object CustomNavTypes {

    val PictureNavType = object: NavType<Picture>(false) {

        override fun get(bundle: Bundle, key: String): Picture? {
            return bundle.getParcelable(key, Picture::class.java)
        }

        override fun parseValue(value: String): Picture {
            return Json.decodeFromString(Uri.decode(value))
        }

        override fun serializeAsValue(value: Picture): String {
            return Uri.encode(Json.encodeToString(Picture.serializer(), value))
        }

        override fun put(bundle: Bundle, key: String, value: Picture) {
            bundle.putParcelable(key, value)
        }
    }
}