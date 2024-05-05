package com.rohansahana.tamm_assignment.di;

@javax.inject.Singleton
@dagger.Component(modules = {com.rohansahana.tamm_assignment.di.NetworkModule.class, com.rohansahana.tamm_assignment.di.DatabaseModule.class, com.rohansahana.tamm_assignment.di.ViewModelModule.class})
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\nJ\u0018\u0010\u0002\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\u00050\u0003H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&\u00a8\u0006\u000b"}, d2 = {"Lcom/rohansahana/tamm_assignment/di/ApplicationComponent;", "", "getMap", "", "Ljava/lang/Class;", "Landroidx/lifecycle/ViewModel;", "inject", "", "mainActivity", "Lcom/rohansahana/tamm_assignment/MainActivity;", "Factory", "app_debug"})
public abstract interface ApplicationComponent {
    
    public abstract void inject(@org.jetbrains.annotations.NotNull
    com.rohansahana.tamm_assignment.MainActivity mainActivity);
    
    @org.jetbrains.annotations.NotNull
    public abstract java.util.Map<java.lang.Class<?>, androidx.lifecycle.ViewModel> getMap();
    
    @dagger.Component.Factory
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/rohansahana/tamm_assignment/di/ApplicationComponent$Factory;", "", "create", "Lcom/rohansahana/tamm_assignment/di/ApplicationComponent;", "context", "Landroid/content/Context;", "app_debug"})
    public static abstract interface Factory {
        
        @org.jetbrains.annotations.NotNull
        public abstract com.rohansahana.tamm_assignment.di.ApplicationComponent create(@dagger.BindsInstance
        @org.jetbrains.annotations.NotNull
        android.content.Context context);
    }
}