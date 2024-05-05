package com.rohansahana.tamm_assignment.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0011\u0010\u000f\u001a\u00020\u0010H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u0011\u0010\r\u001a\u00020\u0010H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\f8F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lcom/rohansahana/tamm_assignment/repository/UniversityRepository;", "", "universityAPI", "Lcom/rohansahana/tamm_assignment/retrofit/UniversityAPI;", "universityDB", "Lcom/rohansahana/tamm_assignment/db/UniversityDB;", "(Lcom/rohansahana/tamm_assignment/retrofit/UniversityAPI;Lcom/rohansahana/tamm_assignment/db/UniversityDB;)V", "_universities", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/rohansahana/tamm_assignment/models/University;", "universities", "Landroidx/lifecycle/LiveData;", "getUniversities", "()Landroidx/lifecycle/LiveData;", "fetchFromLocalDatabase", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
public final class UniversityRepository {
    @org.jetbrains.annotations.NotNull
    private final com.rohansahana.tamm_assignment.retrofit.UniversityAPI universityAPI = null;
    @org.jetbrains.annotations.NotNull
    private final com.rohansahana.tamm_assignment.db.UniversityDB universityDB = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.rohansahana.tamm_assignment.models.University>> _universities = null;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String TAG = "UniversityRepository";
    @org.jetbrains.annotations.NotNull
    public static final com.rohansahana.tamm_assignment.repository.UniversityRepository.Companion Companion = null;
    
    @javax.inject.Inject
    public UniversityRepository(@org.jetbrains.annotations.NotNull
    com.rohansahana.tamm_assignment.retrofit.UniversityAPI universityAPI, @org.jetbrains.annotations.NotNull
    com.rohansahana.tamm_assignment.db.UniversityDB universityDB) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.rohansahana.tamm_assignment.models.University>> getUniversities() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getUniversities(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object fetchFromLocalDatabase(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/rohansahana/tamm_assignment/repository/UniversityRepository$Companion;", "", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}