package com.example.pix.data.implementations;

import com.example.pix.data.flickr.api.FlickrApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class FlickrRepository_Factory implements Factory<FlickrRepository> {
  private final Provider<FlickrApi> flickrApiProvider;

  public FlickrRepository_Factory(Provider<FlickrApi> flickrApiProvider) {
    this.flickrApiProvider = flickrApiProvider;
  }

  @Override
  public FlickrRepository get() {
    return newInstance(flickrApiProvider.get());
  }

  public static FlickrRepository_Factory create(Provider<FlickrApi> flickrApiProvider) {
    return new FlickrRepository_Factory(flickrApiProvider);
  }

  public static FlickrRepository newInstance(FlickrApi flickrApi) {
    return new FlickrRepository(flickrApi);
  }
}
