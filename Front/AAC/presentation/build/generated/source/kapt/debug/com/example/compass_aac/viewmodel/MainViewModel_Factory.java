// Generated by Dagger (https://dagger.dev).
package com.example.compass_aac.viewmodel;

import com.example.data.repository.FindNodeRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class MainViewModel_Factory implements Factory<MainViewModel> {
  private final Provider<FindNodeRepository> findNodeRepositoryProvider;

  public MainViewModel_Factory(Provider<FindNodeRepository> findNodeRepositoryProvider) {
    this.findNodeRepositoryProvider = findNodeRepositoryProvider;
  }

  @Override
  public MainViewModel get() {
    return newInstance(findNodeRepositoryProvider.get());
  }

  public static MainViewModel_Factory create(
      Provider<FindNodeRepository> findNodeRepositoryProvider) {
    return new MainViewModel_Factory(findNodeRepositoryProvider);
  }

  public static MainViewModel newInstance(FindNodeRepository findNodeRepository) {
    return new MainViewModel(findNodeRepository);
  }
}