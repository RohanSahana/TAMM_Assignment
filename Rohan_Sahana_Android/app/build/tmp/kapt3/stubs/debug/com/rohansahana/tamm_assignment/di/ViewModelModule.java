package com.rohansahana.tamm_assignment.di;

@dagger.Module
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0005H\'\u00a8\u0006\u0006"}, d2 = {"Lcom/rohansahana/tamm_assignment/di/ViewModelModule;", "", "()V", "mainViewModel", "Landroidx/lifecycle/ViewModel;", "Lcom/rohansahana/tamm_assignment/viewmodels/MainViewModel;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public abstract class ViewModelModule {
    
    public ViewModelModule() {
        super();
    }
    
    @dagger.Binds
    @dagger.multibindings.ClassKey(value = com.rohansahana.tamm_assignment.viewmodels.MainViewModel.class)
    @dagger.multibindings.IntoMap
    @org.jetbrains.annotations.NotNull
    public abstract androidx.lifecycle.ViewModel mainViewModel(@org.jetbrains.annotations.NotNull
    com.rohansahana.tamm_assignment.viewmodels.MainViewModel mainViewModel);
}