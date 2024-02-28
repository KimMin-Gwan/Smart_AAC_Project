// Generated by view binder compiler. Do not edit!
package com.example.compass_aac.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.compass_aac.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityFavoriteListBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ConstraintLayout favoriteListView;

  @NonNull
  public final LinearLayout linearLayout2;

  @NonNull
  public final TextView sentenceItem;

  private ActivityFavoriteListBinding(@NonNull ConstraintLayout rootView,
      @NonNull ConstraintLayout favoriteListView, @NonNull LinearLayout linearLayout2,
      @NonNull TextView sentenceItem) {
    this.rootView = rootView;
    this.favoriteListView = favoriteListView;
    this.linearLayout2 = linearLayout2;
    this.sentenceItem = sentenceItem;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityFavoriteListBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityFavoriteListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_favorite_list, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityFavoriteListBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      ConstraintLayout favoriteListView = (ConstraintLayout) rootView;

      id = R.id.linearLayout2;
      LinearLayout linearLayout2 = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout2 == null) {
        break missingId;
      }

      id = R.id.sentenceItem;
      TextView sentenceItem = ViewBindings.findChildViewById(rootView, id);
      if (sentenceItem == null) {
        break missingId;
      }

      return new ActivityFavoriteListBinding((ConstraintLayout) rootView, favoriteListView,
          linearLayout2, sentenceItem);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}