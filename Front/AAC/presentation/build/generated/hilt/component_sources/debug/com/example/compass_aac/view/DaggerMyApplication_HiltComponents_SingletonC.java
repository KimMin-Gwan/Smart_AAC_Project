// Generated by Dagger (https://dagger.dev).
package com.example.compass_aac.view;

import android.app.Activity;
import android.app.Service;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.example.compass_aac.module.DataSourceModule;
import com.example.compass_aac.module.DataSourceModule_ProvideLocationSourceFactory;
import com.example.compass_aac.module.DataSourceModule_ProvideUserSourceFactory;
import com.example.compass_aac.module.LocationModule;
import com.example.compass_aac.module.LocationModule_ProvideFusedLocationProviderClientFactory;
import com.example.compass_aac.module.LocationModule_ProvideLocationApiFactory;
import com.example.compass_aac.module.NetworkModule;
import com.example.compass_aac.module.NetworkModule_ProvideOkHttpClientFactory;
import com.example.compass_aac.module.NetworkModule_ProvideRetrofitFactory;
import com.example.compass_aac.module.UseCaseModule;
import com.example.compass_aac.module.UseCaseModule_ProvideLocationUseCaseFactory;
import com.example.compass_aac.module.UseCaseModule_ProvideLoginUseCaseFactory;
import com.example.compass_aac.module.UseCaseModule_ProvideRegisterUseCaseFactory;
import com.example.compass_aac.module.UserModule;
import com.example.compass_aac.module.UserModule_ProvideLoginApiFactory;
import com.example.compass_aac.view.dailyaac.DailyCategory;
import com.example.compass_aac.view.location.SearchLocation;
import com.example.compass_aac.view.login.LoginMain;
import com.example.compass_aac.view.login.RegisterMain;
import com.example.compass_aac.view.login.TitleActivity;
import com.example.compass_aac.view.urgencyaac.UrgencyCategory;
import com.example.compass_aac.view.voiceaac.ChooseWordPass;
import com.example.compass_aac.view.voiceaac.ChooseWordVoice;
import com.example.compass_aac.view.voiceaac.PassCategory;
import com.example.compass_aac.view.voiceaac.ShowSelectedWord;
import com.example.compass_aac.viewmodel.LocationViewModel;
import com.example.compass_aac.viewmodel.LocationViewModel_HiltModules_KeyModule_ProvideFactory;
import com.example.compass_aac.viewmodel.LoginViewModel;
import com.example.compass_aac.viewmodel.LoginViewModel_HiltModules_KeyModule_ProvideFactory;
import com.example.compass_aac.viewmodel.PassCategoryViewModel;
import com.example.compass_aac.viewmodel.PassCategoryViewModel_HiltModules_KeyModule_ProvideFactory;
import com.example.compass_aac.viewmodel.RegisterViewModel;
import com.example.compass_aac.viewmodel.RegisterViewModel_HiltModules_KeyModule_ProvideFactory;
import com.example.data.repository.LocationRepositoryImpl;
import com.example.data.repository.UserRepositoryImpl;
import com.example.data.source.LocationApiService;
import com.example.data.source.UserApiService;
import com.example.data.source.remote.LocationDataSource;
import com.example.data.source.remote.LocationDataSourceImpl;
import com.example.data.source.remote.UserDataSource;
import com.example.data.source.remote.UserDataSourceImpl;
import com.example.domain.usecase.LocationUseCase;
import com.example.domain.usecase.LoginUseCase;
import com.example.domain.usecase.RegisterUseCase;
import com.google.android.gms.location.FusedLocationProviderClient;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.ViewModelLifecycle;
import dagger.hilt.android.flags.HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideApplicationFactory;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.MapBuilder;
import dagger.internal.Preconditions;
import dagger.internal.SetBuilder;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javax.inject.Provider;
import retrofit2.Retrofit;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DaggerMyApplication_HiltComponents_SingletonC {
  private DaggerMyApplication_HiltComponents_SingletonC() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private ApplicationContextModule applicationContextModule;

    private DataSourceModule dataSourceModule;

    private LocationModule locationModule;

    private UserModule userModule;

    private Builder() {
    }

    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      this.applicationContextModule = Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    public Builder dataSourceModule(DataSourceModule dataSourceModule) {
      this.dataSourceModule = Preconditions.checkNotNull(dataSourceModule);
      return this;
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder networkModule(NetworkModule networkModule) {
      Preconditions.checkNotNull(networkModule);
      return this;
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder hiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule(
        HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule hiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule) {
      Preconditions.checkNotNull(hiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule);
      return this;
    }

    public Builder locationModule(LocationModule locationModule) {
      this.locationModule = Preconditions.checkNotNull(locationModule);
      return this;
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder useCaseModule(UseCaseModule useCaseModule) {
      Preconditions.checkNotNull(useCaseModule);
      return this;
    }

    public Builder userModule(UserModule userModule) {
      this.userModule = Preconditions.checkNotNull(userModule);
      return this;
    }

    public MyApplication_HiltComponents.SingletonC build() {
      Preconditions.checkBuilderRequirement(applicationContextModule, ApplicationContextModule.class);
      if (dataSourceModule == null) {
        this.dataSourceModule = new DataSourceModule();
      }
      if (locationModule == null) {
        this.locationModule = new LocationModule();
      }
      if (userModule == null) {
        this.userModule = new UserModule();
      }
      return new SingletonCImpl(applicationContextModule, dataSourceModule, locationModule, userModule);
    }
  }

  private static final class ActivityRetainedCBuilder implements MyApplication_HiltComponents.ActivityRetainedC.Builder {
    private final SingletonCImpl singletonCImpl;

    private ActivityRetainedCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public MyApplication_HiltComponents.ActivityRetainedC build() {
      return new ActivityRetainedCImpl(singletonCImpl);
    }
  }

  private static final class ActivityCBuilder implements MyApplication_HiltComponents.ActivityC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private Activity activity;

    private ActivityCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ActivityCBuilder activity(Activity activity) {
      this.activity = Preconditions.checkNotNull(activity);
      return this;
    }

    @Override
    public MyApplication_HiltComponents.ActivityC build() {
      Preconditions.checkBuilderRequirement(activity, Activity.class);
      return new ActivityCImpl(singletonCImpl, activityRetainedCImpl, activity);
    }
  }

  private static final class FragmentCBuilder implements MyApplication_HiltComponents.FragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private Fragment fragment;

    private FragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public FragmentCBuilder fragment(Fragment fragment) {
      this.fragment = Preconditions.checkNotNull(fragment);
      return this;
    }

    @Override
    public MyApplication_HiltComponents.FragmentC build() {
      Preconditions.checkBuilderRequirement(fragment, Fragment.class);
      return new FragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragment);
    }
  }

  private static final class ViewWithFragmentCBuilder implements MyApplication_HiltComponents.ViewWithFragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private View view;

    private ViewWithFragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;
    }

    @Override
    public ViewWithFragmentCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public MyApplication_HiltComponents.ViewWithFragmentC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewWithFragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl, view);
    }
  }

  private static final class ViewCBuilder implements MyApplication_HiltComponents.ViewC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private View view;

    private ViewCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public ViewCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public MyApplication_HiltComponents.ViewC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, view);
    }
  }

  private static final class ViewModelCBuilder implements MyApplication_HiltComponents.ViewModelC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private SavedStateHandle savedStateHandle;

    private ViewModelLifecycle viewModelLifecycle;

    private ViewModelCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ViewModelCBuilder savedStateHandle(SavedStateHandle handle) {
      this.savedStateHandle = Preconditions.checkNotNull(handle);
      return this;
    }

    @Override
    public ViewModelCBuilder viewModelLifecycle(ViewModelLifecycle viewModelLifecycle) {
      this.viewModelLifecycle = Preconditions.checkNotNull(viewModelLifecycle);
      return this;
    }

    @Override
    public MyApplication_HiltComponents.ViewModelC build() {
      Preconditions.checkBuilderRequirement(savedStateHandle, SavedStateHandle.class);
      Preconditions.checkBuilderRequirement(viewModelLifecycle, ViewModelLifecycle.class);
      return new ViewModelCImpl(singletonCImpl, activityRetainedCImpl, savedStateHandle, viewModelLifecycle);
    }
  }

  private static final class ServiceCBuilder implements MyApplication_HiltComponents.ServiceC.Builder {
    private final SingletonCImpl singletonCImpl;

    private Service service;

    private ServiceCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public MyApplication_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(singletonCImpl, service);
    }
  }

  private static final class ViewWithFragmentCImpl extends MyApplication_HiltComponents.ViewWithFragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private final ViewWithFragmentCImpl viewWithFragmentCImpl = this;

    private ViewWithFragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;


    }
  }

  private static final class FragmentCImpl extends MyApplication_HiltComponents.FragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl = this;

    private FragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        Fragment fragmentParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return activityCImpl.getHiltInternalFactoryFactory();
    }

    @Override
    public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
      return new ViewWithFragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl);
    }
  }

  private static final class ViewCImpl extends MyApplication_HiltComponents.ViewC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final ViewCImpl viewCImpl = this;

    private ViewCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }
  }

  private static final class ActivityCImpl extends MyApplication_HiltComponents.ActivityC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl = this;

    private ActivityCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, Activity activityParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;


    }

    @Override
    public void injectMainActivity(MainActivity arg0) {
    }

    @Override
    public void injectDailyCategory(DailyCategory arg0) {
    }

    @Override
    public void injectSearchLocation(SearchLocation arg0) {
    }

    @Override
    public void injectLoginMain(LoginMain arg0) {
    }

    @Override
    public void injectRegisterMain(RegisterMain arg0) {
    }

    @Override
    public void injectTitleActivity(TitleActivity arg0) {
    }

    @Override
    public void injectUrgencyCategory(UrgencyCategory arg0) {
    }

    @Override
    public void injectChooseWordPass(ChooseWordPass arg0) {
    }

    @Override
    public void injectChooseWordVoice(ChooseWordVoice arg0) {
    }

    @Override
    public void injectPassCategory(PassCategory arg0) {
    }

    @Override
    public void injectShowSelectedWord(ShowSelectedWord arg0) {
    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(getViewModelKeys(), new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl));
    }

    @Override
    public Set<String> getViewModelKeys() {
      return SetBuilder.<String>newSetBuilder(4).add(LocationViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(LoginViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(PassCategoryViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(RegisterViewModel_HiltModules_KeyModule_ProvideFactory.provide()).build();
    }

    @Override
    public ViewModelComponentBuilder getViewModelComponentBuilder() {
      return new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public FragmentComponentBuilder fragmentComponentBuilder() {
      return new FragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @Override
    public ViewComponentBuilder viewComponentBuilder() {
      return new ViewCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }
  }

  private static final class ViewModelCImpl extends MyApplication_HiltComponents.ViewModelC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ViewModelCImpl viewModelCImpl = this;

    private Provider<LocationViewModel> locationViewModelProvider;

    private Provider<LoginViewModel> loginViewModelProvider;

    private Provider<PassCategoryViewModel> passCategoryViewModelProvider;

    private Provider<RegisterViewModel> registerViewModelProvider;

    private ViewModelCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, SavedStateHandle savedStateHandleParam,
        ViewModelLifecycle viewModelLifecycleParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;

      initialize(savedStateHandleParam, viewModelLifecycleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandle savedStateHandleParam,
        final ViewModelLifecycle viewModelLifecycleParam) {
      this.locationViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 0);
      this.loginViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 1);
      this.passCategoryViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 2);
      this.registerViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 3);
    }

    @Override
    public Map<String, Provider<ViewModel>> getHiltViewModelMap() {
      return MapBuilder.<String, Provider<ViewModel>>newMapBuilder(4).put("com.example.compass_aac.viewmodel.LocationViewModel", ((Provider) locationViewModelProvider)).put("com.example.compass_aac.viewmodel.LoginViewModel", ((Provider) loginViewModelProvider)).put("com.example.compass_aac.viewmodel.PassCategoryViewModel", ((Provider) passCategoryViewModelProvider)).put("com.example.compass_aac.viewmodel.RegisterViewModel", ((Provider) registerViewModelProvider)).build();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final ViewModelCImpl viewModelCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          ViewModelCImpl viewModelCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.viewModelCImpl = viewModelCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.example.compass_aac.viewmodel.LocationViewModel 
          return (T) new LocationViewModel(singletonCImpl.locationUseCase(), ApplicationContextModule_ProvideApplicationFactory.provideApplication(singletonCImpl.applicationContextModule));

          case 1: // com.example.compass_aac.viewmodel.LoginViewModel 
          return (T) new LoginViewModel(singletonCImpl.provideLoginUseCaseProvider.get());

          case 2: // com.example.compass_aac.viewmodel.PassCategoryViewModel 
          return (T) new PassCategoryViewModel();

          case 3: // com.example.compass_aac.viewmodel.RegisterViewModel 
          return (T) new RegisterViewModel(singletonCImpl.provideRegisterUseCaseProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ActivityRetainedCImpl extends MyApplication_HiltComponents.ActivityRetainedC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl = this;

    private Provider<ActivityRetainedLifecycle> provideActivityRetainedLifecycleProvider;

    private ActivityRetainedCImpl(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;

      initialize();

    }

    @SuppressWarnings("unchecked")
    private void initialize() {
      this.provideActivityRetainedLifecycleProvider = DoubleCheck.provider(new SwitchingProvider<ActivityRetainedLifecycle>(singletonCImpl, activityRetainedCImpl, 0));
    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
      return provideActivityRetainedLifecycleProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // dagger.hilt.android.ActivityRetainedLifecycle 
          return (T) ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory.provideActivityRetainedLifecycle();

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ServiceCImpl extends MyApplication_HiltComponents.ServiceC {
    private final SingletonCImpl singletonCImpl;

    private final ServiceCImpl serviceCImpl = this;

    private ServiceCImpl(SingletonCImpl singletonCImpl, Service serviceParam) {
      this.singletonCImpl = singletonCImpl;


    }
  }

  private static final class SingletonCImpl extends MyApplication_HiltComponents.SingletonC {
    private final DataSourceModule dataSourceModule;

    private final LocationModule locationModule;

    private final ApplicationContextModule applicationContextModule;

    private final UserModule userModule;

    private final SingletonCImpl singletonCImpl = this;

    private Provider<LocationApiService> provideLocationApiProvider;

    private Provider<FusedLocationProviderClient> provideFusedLocationProviderClientProvider;

    private Provider<UserApiService> provideLoginApiProvider;

    private Provider<LoginUseCase> provideLoginUseCaseProvider;

    private Provider<RegisterUseCase> provideRegisterUseCaseProvider;

    private SingletonCImpl(ApplicationContextModule applicationContextModuleParam,
        DataSourceModule dataSourceModuleParam, LocationModule locationModuleParam,
        UserModule userModuleParam) {
      this.dataSourceModule = dataSourceModuleParam;
      this.locationModule = locationModuleParam;
      this.applicationContextModule = applicationContextModuleParam;
      this.userModule = userModuleParam;
      initialize(applicationContextModuleParam, dataSourceModuleParam, locationModuleParam, userModuleParam);

    }

    private Retrofit retrofit() {
      return NetworkModule_ProvideRetrofitFactory.provideRetrofit(NetworkModule_ProvideOkHttpClientFactory.provideOkHttpClient());
    }

    private LocationDataSourceImpl locationDataSourceImpl() {
      return new LocationDataSourceImpl(provideLocationApiProvider.get(), provideFusedLocationProviderClientProvider.get(), ApplicationContextModule_ProvideContextFactory.provideContext(applicationContextModule));
    }

    private LocationDataSource locationDataSource() {
      return DataSourceModule_ProvideLocationSourceFactory.provideLocationSource(dataSourceModule, locationDataSourceImpl());
    }

    private LocationRepositoryImpl locationRepositoryImpl() {
      return new LocationRepositoryImpl(locationDataSource());
    }

    private LocationUseCase locationUseCase() {
      return UseCaseModule_ProvideLocationUseCaseFactory.provideLocationUseCase(locationRepositoryImpl());
    }

    private UserDataSourceImpl userDataSourceImpl() {
      return new UserDataSourceImpl(provideLoginApiProvider.get());
    }

    private UserDataSource userDataSource() {
      return DataSourceModule_ProvideUserSourceFactory.provideUserSource(dataSourceModule, userDataSourceImpl());
    }

    private UserRepositoryImpl userRepositoryImpl() {
      return new UserRepositoryImpl(userDataSource());
    }

    @SuppressWarnings("unchecked")
    private void initialize(final ApplicationContextModule applicationContextModuleParam,
        final DataSourceModule dataSourceModuleParam, final LocationModule locationModuleParam,
        final UserModule userModuleParam) {
      this.provideLocationApiProvider = DoubleCheck.provider(new SwitchingProvider<LocationApiService>(singletonCImpl, 0));
      this.provideFusedLocationProviderClientProvider = DoubleCheck.provider(new SwitchingProvider<FusedLocationProviderClient>(singletonCImpl, 1));
      this.provideLoginApiProvider = DoubleCheck.provider(new SwitchingProvider<UserApiService>(singletonCImpl, 3));
      this.provideLoginUseCaseProvider = DoubleCheck.provider(new SwitchingProvider<LoginUseCase>(singletonCImpl, 2));
      this.provideRegisterUseCaseProvider = DoubleCheck.provider(new SwitchingProvider<RegisterUseCase>(singletonCImpl, 4));
    }

    @Override
    public void injectMyApplication(MyApplication myApplication) {
    }

    @Override
    public Set<Boolean> getDisableFragmentGetContextFix() {
      return Collections.<Boolean>emptySet();
    }

    @Override
    public ActivityRetainedComponentBuilder retainedComponentBuilder() {
      return new ActivityRetainedCBuilder(singletonCImpl);
    }

    @Override
    public ServiceComponentBuilder serviceComponentBuilder() {
      return new ServiceCBuilder(singletonCImpl);
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.example.data.source.LocationApiService 
          return (T) LocationModule_ProvideLocationApiFactory.provideLocationApi(singletonCImpl.locationModule, singletonCImpl.retrofit());

          case 1: // com.google.android.gms.location.FusedLocationProviderClient 
          return (T) LocationModule_ProvideFusedLocationProviderClientFactory.provideFusedLocationProviderClient(singletonCImpl.locationModule, ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 2: // com.example.domain.usecase.LoginUseCase 
          return (T) UseCaseModule_ProvideLoginUseCaseFactory.provideLoginUseCase(singletonCImpl.userRepositoryImpl());

          case 3: // com.example.data.source.UserApiService 
          return (T) UserModule_ProvideLoginApiFactory.provideLoginApi(singletonCImpl.userModule, singletonCImpl.retrofit());

          case 4: // com.example.domain.usecase.RegisterUseCase 
          return (T) UseCaseModule_ProvideRegisterUseCaseFactory.provideRegisterUseCase(singletonCImpl.userRepositoryImpl());

          default: throw new AssertionError(id);
        }
      }
    }
  }
}
