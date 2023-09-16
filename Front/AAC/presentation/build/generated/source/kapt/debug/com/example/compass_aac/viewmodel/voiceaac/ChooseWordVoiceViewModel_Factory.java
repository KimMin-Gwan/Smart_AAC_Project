// Generated by Dagger (https://dagger.dev).
package com.example.compass_aac.viewmodel.voiceaac;

import com.example.data.repository.FindNodeRepository;
import com.example.domain.usecase.VoiceUseCase;
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
public final class ChooseWordVoiceViewModel_Factory implements Factory<ChooseWordVoiceViewModel> {
  private final Provider<FindNodeRepository> findNodeRepositoryProvider;

  private final Provider<VoiceUseCase> voiceUseCaseProvider;

  public ChooseWordVoiceViewModel_Factory(Provider<FindNodeRepository> findNodeRepositoryProvider,
      Provider<VoiceUseCase> voiceUseCaseProvider) {
    this.findNodeRepositoryProvider = findNodeRepositoryProvider;
    this.voiceUseCaseProvider = voiceUseCaseProvider;
  }

  @Override
  public ChooseWordVoiceViewModel get() {
    return newInstance(findNodeRepositoryProvider.get(), voiceUseCaseProvider.get());
  }

  public static ChooseWordVoiceViewModel_Factory create(
      Provider<FindNodeRepository> findNodeRepositoryProvider,
      Provider<VoiceUseCase> voiceUseCaseProvider) {
    return new ChooseWordVoiceViewModel_Factory(findNodeRepositoryProvider, voiceUseCaseProvider);
  }

  public static ChooseWordVoiceViewModel newInstance(FindNodeRepository findNodeRepository,
      VoiceUseCase voiceUseCase) {
    return new ChooseWordVoiceViewModel(findNodeRepository, voiceUseCase);
  }
}