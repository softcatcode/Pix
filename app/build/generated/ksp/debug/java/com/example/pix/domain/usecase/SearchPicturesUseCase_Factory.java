package com.example.pix.domain.usecase;

import com.example.pix.domain.interfaces.PicturesRepository;
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
public final class SearchPicturesUseCase_Factory implements Factory<SearchPicturesUseCase> {
  private final Provider<PicturesRepository> repositoryProvider;

  public SearchPicturesUseCase_Factory(Provider<PicturesRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public SearchPicturesUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static SearchPicturesUseCase_Factory create(
      Provider<PicturesRepository> repositoryProvider) {
    return new SearchPicturesUseCase_Factory(repositoryProvider);
  }

  public static SearchPicturesUseCase newInstance(PicturesRepository repository) {
    return new SearchPicturesUseCase(repository);
  }
}
