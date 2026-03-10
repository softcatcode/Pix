package com.example.pix.di.components;

import androidx.lifecycle.ViewModel;
import com.example.pix.data.implementations.FlickrRepository;
import com.example.pix.data.implementations.FlickrRepository_Factory;
import com.example.pix.di.ViewModelFactory;
import com.example.pix.di.modules.PictureListModule_Companion_ProvideFlickrApiServiceFactory;
import com.example.pix.domain.entity.Picture;
import com.example.pix.domain.interfaces.PicturesRepository;
import com.example.pix.domain.usecase.SearchPicturesUseCase;
import com.example.pix.domain.usecase.SearchPicturesUseCase_Factory;
import com.example.pix.domain.usecase.TransformPictureSizeUseCase;
import com.example.pix.domain.usecase.TransformPictureSizeUseCase_Factory;
import com.example.pix.presentation.pictureView.PictureViewModel;
import com.example.pix.presentation.pictureView.PictureViewModel_Factory;
import com.example.pix.presentation.picturesGrid.PictureListViewModel;
import com.example.pix.presentation.picturesGrid.PictureListViewModel_Factory;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.MapBuilder;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import java.util.Collections;
import java.util.Map;
import javax.annotation.processing.Generated;

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
public final class DaggerPictureListComponent {
  private DaggerPictureListComponent() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static PictureListComponent create() {
    return new Builder().build();
  }

  public static final class Builder {
    private Builder() {
    }

    public PictureListComponent build() {
      return new PictureListComponentImpl();
    }
  }

  private static final class PictureViewComponentFactory implements PictureViewComponent.Factory {
    private final PictureListComponentImpl pictureListComponentImpl;

    private PictureViewComponentFactory(PictureListComponentImpl pictureListComponentImpl) {
      this.pictureListComponentImpl = pictureListComponentImpl;
    }

    @Override
    public PictureViewComponent create(Picture picture) {
      Preconditions.checkNotNull(picture);
      return new PictureViewComponentImpl(pictureListComponentImpl, picture);
    }
  }

  private static final class PictureViewComponentImpl implements PictureViewComponent {
    private final PictureListComponentImpl pictureListComponentImpl;

    private final PictureViewComponentImpl pictureViewComponentImpl = this;

    private Provider<Picture> pictureProvider;

    private Provider<TransformPictureSizeUseCase> transformPictureSizeUseCaseProvider;

    private Provider<PictureViewModel> pictureViewModelProvider;

    private PictureViewComponentImpl(PictureListComponentImpl pictureListComponentImpl,
        Picture pictureParam) {
      this.pictureListComponentImpl = pictureListComponentImpl;

      initialize(pictureParam);

    }

    private Map<Class<? extends ViewModel>, javax.inject.Provider<ViewModel>> mapOfClassOfAndProviderOfViewModel(
        ) {
      return MapBuilder.<Class<? extends ViewModel>, javax.inject.Provider<ViewModel>>newMapBuilder(2).put(PictureListViewModel.class, ((Provider) pictureListComponentImpl.pictureListViewModelProvider)).put(PictureViewModel.class, ((Provider) pictureViewModelProvider)).build();
    }

    @SuppressWarnings("unchecked")
    private void initialize(final Picture pictureParam) {
      this.pictureProvider = InstanceFactory.create(pictureParam);
      this.transformPictureSizeUseCaseProvider = TransformPictureSizeUseCase_Factory.create(pictureListComponentImpl.bindPictureRepositoryProvider);
      this.pictureViewModelProvider = PictureViewModel_Factory.create(pictureProvider, transformPictureSizeUseCaseProvider);
    }

    @Override
    public ViewModelFactory getViewModelFactory() {
      return new ViewModelFactory(mapOfClassOfAndProviderOfViewModel());
    }
  }

  private static final class PictureListComponentImpl implements PictureListComponent {
    private final PictureListComponentImpl pictureListComponentImpl = this;

    private Provider<FlickrRepository> flickrRepositoryProvider;

    private Provider<PicturesRepository> bindPictureRepositoryProvider;

    private Provider<SearchPicturesUseCase> searchPicturesUseCaseProvider;

    private Provider<PictureListViewModel> pictureListViewModelProvider;

    private PictureListComponentImpl() {

      initialize();

    }

    private Map<Class<? extends ViewModel>, javax.inject.Provider<ViewModel>> mapOfClassOfAndProviderOfViewModel(
        ) {
      return Collections.<Class<? extends ViewModel>, javax.inject.Provider<ViewModel>>singletonMap(PictureListViewModel.class, ((Provider) pictureListViewModelProvider));
    }

    @SuppressWarnings("unchecked")
    private void initialize() {
      this.flickrRepositoryProvider = FlickrRepository_Factory.create(PictureListModule_Companion_ProvideFlickrApiServiceFactory.create());
      this.bindPictureRepositoryProvider = DoubleCheck.provider((Provider) flickrRepositoryProvider);
      this.searchPicturesUseCaseProvider = SearchPicturesUseCase_Factory.create(bindPictureRepositoryProvider);
      this.pictureListViewModelProvider = PictureListViewModel_Factory.create(searchPicturesUseCaseProvider);
    }

    @Override
    public ViewModelFactory getViewModelFactory() {
      return new ViewModelFactory(mapOfClassOfAndProviderOfViewModel());
    }

    @Override
    public PictureViewComponent.Factory getPictureViewComponentFactory() {
      return new PictureViewComponentFactory(pictureListComponentImpl);
    }
  }
}
