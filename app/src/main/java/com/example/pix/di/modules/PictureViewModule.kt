package com.example.pix.di.modules

import androidx.lifecycle.ViewModel
import com.example.pix.di.annotations.ViewModelKey
import com.example.pix.presentation.pictureView.PictureViewModel
import com.example.pix.presentation.picturesGrid.PictureListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface PictureViewModule {
    @IntoMap
    @ViewModelKey(PictureViewModel::class)
    @Binds
    fun bindPictureViewModel(impl: PictureViewModel): ViewModel
}