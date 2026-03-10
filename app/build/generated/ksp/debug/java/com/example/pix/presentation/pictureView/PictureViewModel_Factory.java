package com.example.pix.presentation.pictureView;

import com.example.pix.domain.entity.Picture;
import com.example.pix.domain.usecase.TransformPictureSizeUseCase;
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
public final class PictureViewModel_Factory implements Factory<PictureViewModel> {
  private final Provider<Picture> pictureProvider;

  private final Provider<TransformPictureSizeUseCase> transformPictureSizeUseCaseProvider;

  public PictureViewModel_Factory(Provider<Picture> pictureProvider,
      Provider<TransformPictureSizeUseCase> transformPictureSizeUseCaseProvider) {
    this.pictureProvider = pictureProvider;
    this.transformPictureSizeUseCaseProvider = transformPictureSizeUseCaseProvider;
  }

  @Override
  public PictureViewModel get() {
    return newInstance(pictureProvider.get(), transformPictureSizeUseCaseProvider.get());
  }

  public static PictureViewModel_Factory create(Provider<Picture> pictureProvider,
      Provider<TransformPictureSizeUseCase> transformPictureSizeUseCaseProvider) {
    return new PictureViewModel_Factory(pictureProvider, transformPictureSizeUseCaseProvider);
  }

  public static PictureViewModel newInstance(Picture picture,
      TransformPictureSizeUseCase transformPictureSizeUseCase) {
    return new PictureViewModel(picture, transformPictureSizeUseCase);
  }
}
