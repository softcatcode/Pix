package com.example.pix.di.components

import com.example.pix.di.ViewModelFactory
import com.example.pix.di.modules.PictureViewModule
import com.example.pix.domain.entity.Picture
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(modules = [PictureViewModule::class])
interface PictureViewComponent {

    fun getViewModelFactory(): ViewModelFactory

    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance picture: Picture
        ): PictureViewComponent
    }
}