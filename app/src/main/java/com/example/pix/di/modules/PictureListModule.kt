package com.example.pix.di.modules

import androidx.lifecycle.ViewModel
import com.example.pix.data.flickr.api.FlickrApi
import com.example.pix.data.flickr.api.FlickrRetrofit
import com.example.pix.data.implementations.FlickrRepository
import com.example.pix.di.annotations.ApplicationScope
import com.example.pix.di.annotations.ViewModelKey
import com.example.pix.domain.interfaces.PicturesRepository
import com.example.pix.presentation.picturesGrid.PictureListViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
interface PictureListModule {

    @Binds
    @ApplicationScope
    fun bindPictureRepository(impl: FlickrRepository): PicturesRepository

    @IntoMap
    @ViewModelKey(PictureListViewModel::class)
    @Binds
    fun bindPictureListViewModel(impl: PictureListViewModel): ViewModel

    companion object {
        @Provides
        fun provideFlickrApiService(): FlickrApi = FlickrRetrofit.api.value
    }
}