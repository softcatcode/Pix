package com.example.pix

import android.app.Application
import com.example.pix.di.components.DaggerPictureListComponent

class PicturesApplication: Application() {
    val picturesComponent by lazy {
        DaggerPictureListComponent.create()
    }
}