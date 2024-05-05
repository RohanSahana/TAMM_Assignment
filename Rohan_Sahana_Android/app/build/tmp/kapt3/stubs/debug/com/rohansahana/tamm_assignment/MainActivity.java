package com.rohansahana.tamm_assignment;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\u0012\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/rohansahana/tamm_assignment/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "colorIndex", "", "mainViewModel", "Lcom/rohansahana/tamm_assignment/viewmodels/MainViewModel;", "mainViewModelFactory", "Lcom/rohansahana/tamm_assignment/viewmodels/MainViewModelFactory;", "getMainViewModelFactory", "()Lcom/rohansahana/tamm_assignment/viewmodels/MainViewModelFactory;", "setMainViewModelFactory", "(Lcom/rohansahana/tamm_assignment/viewmodels/MainViewModelFactory;)V", "universitiesLayout", "Landroid/widget/LinearLayout;", "buildUniversityText", "", "university", "Lcom/rohansahana/tamm_assignment/models/University;", "createUniversityCardView", "Landroidx/cardview/widget/CardView;", "bg", "navigateToDetailsScreen", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.rohansahana.tamm_assignment.viewmodels.MainViewModel mainViewModel;
    @javax.inject.Inject
    public com.rohansahana.tamm_assignment.viewmodels.MainViewModelFactory mainViewModelFactory;
    private android.widget.LinearLayout universitiesLayout;
    private int colorIndex = 0;
    
    public MainActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.rohansahana.tamm_assignment.viewmodels.MainViewModelFactory getMainViewModelFactory() {
        return null;
    }
    
    public final void setMainViewModelFactory(@org.jetbrains.annotations.NotNull
    com.rohansahana.tamm_assignment.viewmodels.MainViewModelFactory p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final androidx.cardview.widget.CardView createUniversityCardView(com.rohansahana.tamm_assignment.models.University university, int bg) {
        return null;
    }
    
    private final java.lang.String buildUniversityText(com.rohansahana.tamm_assignment.models.University university) {
        return null;
    }
    
    private final void navigateToDetailsScreen(com.rohansahana.tamm_assignment.models.University university, int bg) {
    }
}