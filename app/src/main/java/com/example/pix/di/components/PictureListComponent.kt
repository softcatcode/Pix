package com.example.pix.di.components

import com.example.pix.di.ViewModelFactory
import com.example.pix.di.annotations.ApplicationScope
import com.example.pix.di.modules.PictureListModule
import dagger.Component

@Component(modules = [PictureListModule::class])
@ApplicationScope
interface PictureListComponent {
    fun getViewModelFactory(): ViewModelFactory

    fun getPictureViewComponentFactory(): PictureViewComponent.Factory
}