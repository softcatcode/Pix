package com.example.pix.presentation.extensions

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.pix.PicturesApplication
import com.example.pix.di.components.PictureListComponent
import com.example.pix.domain.entity.Picture

@Composable
fun getApplicationComponent(): PictureListComponent =
    (LocalContext.current.applicationContext as PicturesApplication).picturesComponent

@Composable
fun getPictureViewComponent(picture: Picture) =
    getApplicationComponent().getPictureViewComponentFactory().create(picture)