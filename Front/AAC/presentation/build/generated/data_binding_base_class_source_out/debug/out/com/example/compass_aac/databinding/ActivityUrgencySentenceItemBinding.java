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

public final class ActivityUrgencySentenceItemBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final LinearLayout sentenceLine;

  @NonNull
  public final TextView sentenceList;

  @NonNull
  public final ConstraintLayout urgencyItem;

  private ActivityUrgencySentenceItemBinding(@NonNull ConstraintLayout rootView,
      @NonNull LinearLayout sentenceLine, @NonNull TextView sentenceList,
      @NonNull ConstraintLayout urgencyItem) {
    this.rootView = rootView;
    this.sentenceLine = sentenceLine;
    this.sentenceList = sentenceList;
    this.urgencyItem = urgencyItem;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityUrgencySentenceItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityUrgencySentenceItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_urgency_sentence_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityUrgencySentenceItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.sentenceLine;
      LinearLayout sentenceLine = ViewBindings.findChildViewById(rootView, id);
      if (sentenceLine == null) {
        break missingId;
      }

      id = R.id.sentenceList;
      TextView sentenceList = ViewBindings.findChildViewById(rootView, id);
      if (sentenceList == null) {
        break missingId;
      }

      ConstraintLayout urgencyItem = (ConstraintLayout) rootView;

      return new ActivityUrgencySentenceItemBinding((ConstraintLayout) rootView, sentenceLine,
          sentenceList, urgencyItem);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}