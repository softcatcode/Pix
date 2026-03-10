package com.example.pix.di.modules;

import com.example.pix.data.flickr.api.FlickrApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class PictureListModule_Companion_ProvideFlickrApiServiceFactory implements Factory<FlickrApi> {
  @Override
  public FlickrApi get() {
    return provideFlickrApiService();
  }

  public static PictureListModule_Companion_ProvideFlickrApiServiceFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static FlickrApi provideFlickrApiService() {
    return Preconditions.checkNotNullFromProvides(PictureListModule.Companion.provideFlickrApiService());
  }

  private static final class InstanceHolder {
    private static final PictureListModule_Companion_ProvideFlickrApiServiceFactory INSTANCE = new PictureListModule_Companion_ProvideFlickrApiServiceFactory();
  }
}
