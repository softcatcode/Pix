package com.example.pix.presentation.picturesGrid;

import com.example.pix.domain.usecase.SearchPicturesUseCase;
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
public final class PictureListViewModel_Factory implements Factory<PictureListViewModel> {
  private final Provider<SearchPicturesUseCase> searchPicturesUseCaseProvider;

  public PictureListViewModel_Factory(
      Provider<SearchPicturesUseCase> searchPicturesUseCaseProvider) {
    this.searchPicturesUseCaseProvider = searchPicturesUseCaseProvider;
  }

  @Override
  public PictureListViewModel get() {
    return newInstance(searchPicturesUseCaseProvider.get());
  }

  public static PictureListViewModel_Factory create(
      Provider<SearchPicturesUseCase> searchPicturesUseCaseProvider) {
    return new PictureListViewModel_Factory(searchPicturesUseCaseProvider);
  }

  public static PictureListViewModel newInstance(SearchPicturesUseCase searchPicturesUseCase) {
    return new PictureListViewModel(searchPicturesUseCase);
  }
}
