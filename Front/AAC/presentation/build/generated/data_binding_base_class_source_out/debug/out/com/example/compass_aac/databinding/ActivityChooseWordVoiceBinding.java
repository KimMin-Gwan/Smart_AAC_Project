// Generated by view binder compiler. Do not edit!
package com.example.compass_aac.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.compass_aac.R;
import com.google.android.material.button.MaterialButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityChooseWordVoiceBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final LinearLayout linearLayout;

  @NonNull
  public final RecyclerView recyclerViewVoice;

  @NonNull
  public final ImageButton selectWordVoiceBackBtn;

  @NonNull
  public final MaterialButton selectedWordVoiceBtn;

  @NonNull
  public final TextView voiceText;

  private ActivityChooseWordVoiceBinding(@NonNull ConstraintLayout rootView,
      @NonNull LinearLayout linearLayout, @NonNull RecyclerView recyclerViewVoice,
      @NonNull ImageButton selectWordVoiceBackBtn, @NonNull MaterialButton selectedWordVoiceBtn,
      @NonNull TextView voiceText) {
    this.rootView = rootView;
    this.linearLayout = linearLayout;
    this.recyclerViewVoice = recyclerViewVoice;
    this.selectWordVoiceBackBtn = selectWordVoiceBackBtn;
    this.selectedWordVoiceBtn = selectedWordVoiceBtn;
    this.voiceText = voiceText;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityChooseWordVoiceBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityChooseWordVoiceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_choose_word_voice, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityChooseWordVoiceBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.linearLayout;
      LinearLayout linearLayout = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout == null) {
        break missingId;
      }

      id = R.id.recycler_view_voice;
      RecyclerView recyclerViewVoice = ViewBindings.findChildViewById(rootView, id);
      if (recyclerViewVoice == null) {
        break missingId;
      }

      id = R.id.select_word_voice_back_btn;
      ImageButton selectWordVoiceBackBtn = ViewBindings.findChildViewById(rootView, id);
      if (selectWordVoiceBackBtn == null) {
        break missingId;
      }

      id = R.id.selectedWordVoiceBtn;
      MaterialButton selectedWordVoiceBtn = ViewBindings.findChildViewById(rootView, id);
      if (selectedWordVoiceBtn == null) {
        break missingId;
      }

      id = R.id.voiceText;
      TextView voiceText = ViewBindings.findChildViewById(rootView, id);
      if (voiceText == null) {
        break missingId;
      }

      return new ActivityChooseWordVoiceBinding((ConstraintLayout) rootView, linearLayout,
          recyclerViewVoice, selectWordVoiceBackBtn, selectedWordVoiceBtn, voiceText);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
