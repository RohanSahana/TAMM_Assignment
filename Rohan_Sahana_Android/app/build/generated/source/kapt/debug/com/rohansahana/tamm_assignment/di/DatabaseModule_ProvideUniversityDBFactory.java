// Generated by Dagger (https://dagger.dev).
package com.rohansahana.tamm_assignment.di;

import android.content.Context;
import com.rohansahana.tamm_assignment.db.UniversityDB;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class DatabaseModule_ProvideUniversityDBFactory implements Factory<UniversityDB> {
  private final DatabaseModule module;

  private final Provider<Context> contextProvider;

  public DatabaseModule_ProvideUniversityDBFactory(DatabaseModule module,
      Provider<Context> contextProvider) {
    this.module = module;
    this.contextProvider = contextProvider;
  }

  @Override
  public UniversityDB get() {
    return provideUniversityDB(module, contextProvider.get());
  }

  public static DatabaseModule_ProvideUniversityDBFactory create(DatabaseModule module,
      Provider<Context> contextProvider) {
    return new DatabaseModule_ProvideUniversityDBFactory(module, contextProvider);
  }

  public static UniversityDB provideUniversityDB(DatabaseModule instance, Context context) {
    return Preconditions.checkNotNullFromProvides(instance.provideUniversityDB(context));
  }
}
