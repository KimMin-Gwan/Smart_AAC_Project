package com.example.compass_aac.view.favorite;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rH\u0002J(\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0018\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0018\u001a\u00020\rH\u0016J@\u0010\"\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u000fH\u0016J \u0010\'\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010(\u001a\u00020\rH\u0016J\u0018\u0010)\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010*\u001a\u00020\u0011H\u0016J\u0018\u0010+\u001a\u00020\u00152\u0006\u0010 \u001a\u00020!2\u0006\u0010,\u001a\u00020\u000fH\u0002J@\u0010-\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u000fH\u0003J@\u0010.\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u000fH\u0003J@\u0010/\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u000fH\u0003R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2 = {"Lcom/example/compass_aac/view/favorite/SwipeController;", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "listener", "Lcom/example/compass_aac/view/favorite/ItemTouchHelperListener;", "(Lcom/example/compass_aac/view/favorite/ItemTouchHelperListener;)V", "()V", "buttonInstance", "Landroid/graphics/RectF;", "buttonWidth", "", "buttonsShowedState", "Lcom/example/compass_aac/view/favorite/ButtonState;", "currentItemViewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "swipeBack", "", "convertToAbsoluteDirection", "", "flags", "layoutDirection", "drawButtons", "", "c", "Landroid/graphics/Canvas;", "viewHolder", "drawText", "text", "", "button", "p", "Landroid/graphics/Paint;", "getMovementFlags", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onChildDraw", "dX", "dY", "actionState", "isCurrentlyActive", "onMove", "target", "onSwiped", "direction", "setItemClickable", "isClickable", "setTouchDownListener", "setTouchListener", "setTouchUpListener", "presentation_debug"})
public final class SwipeController extends androidx.recyclerview.widget.ItemTouchHelper.Callback {
    private boolean swipeBack = false;
    private final float buttonWidth = 200.0F;
    @org.jetbrains.annotations.NotNull
    private com.example.compass_aac.view.favorite.ButtonState buttonsShowedState = com.example.compass_aac.view.favorite.ButtonState.GONE;
    @org.jetbrains.annotations.Nullable
    private android.graphics.RectF buttonInstance;
    private com.example.compass_aac.view.favorite.ItemTouchHelperListener listener;
    @org.jetbrains.annotations.Nullable
    private androidx.recyclerview.widget.RecyclerView.ViewHolder currentItemViewHolder;
    
    public SwipeController() {
        super();
    }
    
    public SwipeController(@org.jetbrains.annotations.NotNull
    com.example.compass_aac.view.favorite.ItemTouchHelperListener listener) {
        super();
    }
    
    @java.lang.Override
    public int getMovementFlags(@org.jetbrains.annotations.NotNull
    androidx.recyclerview.widget.RecyclerView recyclerView, @org.jetbrains.annotations.NotNull
    androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder) {
        return 0;
    }
    
    @java.lang.Override
    public boolean onMove(@org.jetbrains.annotations.NotNull
    androidx.recyclerview.widget.RecyclerView recyclerView, @org.jetbrains.annotations.NotNull
    androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, @org.jetbrains.annotations.NotNull
    androidx.recyclerview.widget.RecyclerView.ViewHolder target) {
        return false;
    }
    
    @java.lang.Override
    public void onSwiped(@org.jetbrains.annotations.NotNull
    androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int direction) {
    }
    
    @java.lang.Override
    public void onChildDraw(@org.jetbrains.annotations.NotNull
    android.graphics.Canvas c, @org.jetbrains.annotations.NotNull
    androidx.recyclerview.widget.RecyclerView recyclerView, @org.jetbrains.annotations.NotNull
    androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
    }
    
    private final void drawButtons(android.graphics.Canvas c, androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder) {
    }
    
    private final void drawText(java.lang.String text, android.graphics.Canvas c, android.graphics.RectF button, android.graphics.Paint p) {
    }
    
    @java.lang.Override
    public int convertToAbsoluteDirection(int flags, int layoutDirection) {
        return 0;
    }
    
    @android.annotation.SuppressLint(value = {"ClickableViewAccessibility"})
    private final void setTouchListener(android.graphics.Canvas c, androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
    }
    
    @android.annotation.SuppressLint(value = {"ClickableViewAccessibility"})
    private final void setTouchDownListener(android.graphics.Canvas c, androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
    }
    
    @android.annotation.SuppressLint(value = {"ClickableViewAccessibility"})
    private final void setTouchUpListener(android.graphics.Canvas c, androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
    }
    
    private final void setItemClickable(androidx.recyclerview.widget.RecyclerView recyclerView, boolean isClickable) {
    }
}