package com.example.compass_aac.view.favorite;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.view.menu.MenuView.ItemView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.example.compass_aac.R;
import com.example.compass_aac.view.adapters.NodeAdapter;
import com.example.data.source.remote.Tree_Node;
import com.example.domain.model.favorite;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001d2\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u00012\u00020\u0004:\u0003\u001d\u001e\u001fB\u0005\u00a2\u0006\u0002\u0010\u0005J\u001c\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001c\u0010\u0011\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0010H\u0016J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u001a\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006 "}, d2 = {"Lcom/example/compass_aac/view/favorite/FavoriteAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/example/domain/model/favorite;", "Lcom/example/compass_aac/view/favorite/FavoriteAdapter$ViewHolder;", "Lcom/example/compass_aac/view/favorite/ItemTouchHelperListener;", "()V", "itemClick", "Lcom/example/compass_aac/view/favorite/FavoriteAdapter$ItemClick;", "getItemClick", "()Lcom/example/compass_aac/view/favorite/FavoriteAdapter$ItemClick;", "setItemClick", "(Lcom/example/compass_aac/view/favorite/FavoriteAdapter$ItemClick;)V", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onItemMove", "", "from_position", "to_position", "onItemSwipe", "onRightClick", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Companion", "ItemClick", "ViewHolder", "presentation_debug"})
public final class FavoriteAdapter extends androidx.recyclerview.widget.ListAdapter<com.example.domain.model.favorite, com.example.compass_aac.view.favorite.FavoriteAdapter.ViewHolder> implements com.example.compass_aac.view.favorite.ItemTouchHelperListener {
    @org.jetbrains.annotations.Nullable
    private com.example.compass_aac.view.favorite.FavoriteAdapter.ItemClick itemClick;
    @org.jetbrains.annotations.NotNull
    private static final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.example.domain.model.favorite> DiffCallback = null;
    @org.jetbrains.annotations.NotNull
    public static final com.example.compass_aac.view.favorite.FavoriteAdapter.Companion Companion = null;
    
    public FavoriteAdapter() {
        super(null);
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.example.compass_aac.view.favorite.FavoriteAdapter.ItemClick getItemClick() {
        return null;
    }
    
    public final void setItemClick(@org.jetbrains.annotations.Nullable
    com.example.compass_aac.view.favorite.FavoriteAdapter.ItemClick p0) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.example.compass_aac.view.favorite.FavoriteAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.example.compass_aac.view.favorite.FavoriteAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public boolean onItemMove(int from_position, int to_position) {
        return false;
    }
    
    @java.lang.Override
    public void onItemSwipe(int position) {
    }
    
    @java.lang.Override
    public void onRightClick(int position, @org.jetbrains.annotations.Nullable
    androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/example/compass_aac/view/favorite/FavoriteAdapter$Companion;", "", "()V", "DiffCallback", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/example/domain/model/favorite;", "presentation_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/example/compass_aac/view/favorite/FavoriteAdapter$ItemClick;", "", "onDelete", "", "view", "Landroid/view/View;", "id", "", "presentation_debug"})
    public static abstract interface ItemClick {
        
        public abstract void onDelete(@org.jetbrains.annotations.NotNull
        android.view.View view, int id);
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/example/compass_aac/view/favorite/FavoriteAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/example/compass_aac/view/favorite/FavoriteAdapter;Landroid/view/View;)V", "sentenceTextView", "Landroid/widget/TextView;", "getSentenceTextView", "()Landroid/widget/TextView;", "textNumber", "getTextNumber", "presentation_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView sentenceTextView = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView textNumber = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View itemView) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getSentenceTextView() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getTextNumber() {
            return null;
        }
    }
}