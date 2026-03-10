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
public final class TransformPictureSizeUseCase_Factory implements Factory<TransformPictureSizeUseCase> {
  private final Provider<PicturesRepository> repositoryProvider;

  public TransformPictureSizeUseCase_Factory(Provider<PicturesRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public TransformPictureSizeUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static TransformPictureSizeUseCase_Factory create(
      Provider<PicturesRepository> repositoryProvider) {
    return new TransformPictureSizeUseCase_Factory(repositoryProvider);
  }

  public static TransformPictureSizeUseCase newInstance(PicturesRepository repository) {
    return new TransformPictureSizeUseCase(repository);
  }
}
