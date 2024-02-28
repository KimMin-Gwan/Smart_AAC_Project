// Generated by Dagger (https://dagger.dev).
package com.example.compass_aac.module;

import com.example.data.source.remote.local.FavoriteSource;
import com.example.data.source.remote.local.FavoriteSourceImpl;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class DataSourceModule_ProvideFavoriteSourceFactory implements Factory<FavoriteSource> {
  private final DataSourceModule module;

  private final Provider<FavoriteSourceImpl> favoriteSourceImplProvider;

  public DataSourceModule_ProvideFavoriteSourceFactory(DataSourceModule module,
      Provider<FavoriteSourceImpl> favoriteSourceImplProvider) {
    this.module = module;
    this.favoriteSourceImplProvider = favoriteSourceImplProvider;
  }

  @Override
  public FavoriteSource get() {
    return provideFavoriteSource(module, favoriteSourceImplProvider.get());
  }

  public static DataSourceModule_ProvideFavoriteSourceFactory create(DataSourceModule module,
      Provider<FavoriteSourceImpl> favoriteSourceImplProvider) {
    return new DataSourceModule_ProvideFavoriteSourceFactory(module, favoriteSourceImplProvider);
  }

  public static FavoriteSource provideFavoriteSource(DataSourceModule instance,
      FavoriteSourceImpl favoriteSourceImpl) {
    return Preconditions.checkNotNullFromProvides(instance.provideFavoriteSource(favoriteSourceImpl));
  }
}