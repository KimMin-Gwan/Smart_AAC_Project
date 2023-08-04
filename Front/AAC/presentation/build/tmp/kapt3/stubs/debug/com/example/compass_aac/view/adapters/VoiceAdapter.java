package com.example.compass_aac.view.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.recyclerview.widget.RecyclerView;
import com.example.compass_aac.R;
import com.example.compass_aac.view.voiceaac.ShowSelectedWord;
import com.example.data.source.remote.Tree_Node;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002./B%\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ6\u0010!\u001a\u00020\"2\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0016\u0010$\u001a\u0012\u0012\u0004\u0012\u00020%0\u0004j\b\u0012\u0004\u0012\u00020%`\u0006J\b\u0010&\u001a\u00020\u0011H\u0016J\u0018\u0010\'\u001a\u00020\"2\u0006\u0010(\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u0011H\u0016J\u0018\u0010*\u001a\u00020\u00022\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0011H\u0016R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R,\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00180\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001d\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00180\u001e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 \u00a8\u00060"}, d2 = {"Lcom/example/compass_aac/view/adapters/VoiceAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/compass_aac/view/adapters/VoiceAdapter$ViewHolder;", "childTree", "Ljava/util/ArrayList;", "Lcom/example/data/source/remote/Tree_Node;", "Lkotlin/collections/ArrayList;", "context", "Landroid/content/Context;", "(Ljava/util/ArrayList;Landroid/content/Context;)V", "itemClick", "Lcom/example/compass_aac/view/adapters/VoiceAdapter$ItemClick;", "getItemClick", "()Lcom/example/compass_aac/view/adapters/VoiceAdapter$ItemClick;", "setItemClick", "(Lcom/example/compass_aac/view/adapters/VoiceAdapter$ItemClick;)V", "layer", "", "getLayer", "()I", "setLayer", "(I)V", "t_hashMap", "Ljava/util/HashMap;", "", "getT_hashMap", "()Ljava/util/HashMap;", "setT_hashMap", "(Ljava/util/HashMap;)V", "totaldataSet", "", "getTotaldataSet", "()Ljava/util/List;", "UpdateChild", "", "childNode", "selectedword", "", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ItemClick", "ViewHolder", "presentation_debug"})
public final class VoiceAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.compass_aac.view.adapters.VoiceAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull
    private java.util.ArrayList<com.example.data.source.remote.Tree_Node> childTree;
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.Nullable
    private com.example.compass_aac.view.adapters.VoiceAdapter.ItemClick itemClick;
    @org.jetbrains.annotations.NotNull
    private java.util.HashMap<java.lang.Integer, java.util.List<java.lang.Integer>> t_hashMap;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<java.util.List<java.lang.Integer>> totaldataSet = null;
    private int layer = 0;
    
    public VoiceAdapter(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.example.data.source.remote.Tree_Node> childTree, @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.example.compass_aac.view.adapters.VoiceAdapter.ItemClick getItemClick() {
        return null;
    }
    
    public final void setItemClick(@org.jetbrains.annotations.Nullable
    com.example.compass_aac.view.adapters.VoiceAdapter.ItemClick p0) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.example.compass_aac.view.adapters.VoiceAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.example.compass_aac.view.adapters.VoiceAdapter.ViewHolder holder, int position) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.HashMap<java.lang.Integer, java.util.List<java.lang.Integer>> getT_hashMap() {
        return null;
    }
    
    public final void setT_hashMap(@org.jetbrains.annotations.NotNull
    java.util.HashMap<java.lang.Integer, java.util.List<java.lang.Integer>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.util.List<java.lang.Integer>> getTotaldataSet() {
        return null;
    }
    
    public final int getLayer() {
        return 0;
    }
    
    public final void setLayer(int p0) {
    }
    
    public final void UpdateChild(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.example.data.source.remote.Tree_Node> childNode, @org.jetbrains.annotations.NotNull
    java.util.ArrayList<java.lang.String> selectedword) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/example/compass_aac/view/adapters/VoiceAdapter$ItemClick;", "", "onClick", "", "view", "Landroid/view/View;", "treeNode", "Lcom/example/data/source/remote/Tree_Node;", "presentation_debug"})
    public static abstract interface ItemClick {
        
        public abstract void onClick(@org.jetbrains.annotations.NotNull
        android.view.View view, @org.jetbrains.annotations.NotNull
        com.example.data.source.remote.Tree_Node treeNode);
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/example/compass_aac/view/adapters/VoiceAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "chooseWord", "Landroid/widget/Button;", "getChooseWord", "()Landroid/widget/Button;", "presentation_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final android.widget.Button chooseWord = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View view) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.Button getChooseWord() {
            return null;
        }
    }
}