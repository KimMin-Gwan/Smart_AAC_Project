package com.example.compass_aac.view.favorite;

import androidx.recyclerview.widget.RecyclerView;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H&J\u001a\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&\u00a8\u0006\r"}, d2 = {"Lcom/example/compass_aac/view/favorite/ItemTouchHelperListener;", "", "onItemMove", "", "from_position", "", "to_position", "onItemSwipe", "", "position", "onRightClick", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "presentation_debug"})
public abstract interface ItemTouchHelperListener {
    
    public abstract boolean onItemMove(int from_position, int to_position);
    
    public abstract void onItemSwipe(int position);
    
    public abstract void onRightClick(int position, @org.jetbrains.annotations.Nullable
    androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder);
}