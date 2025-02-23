// Generated by view binder compiler. Do not edit!
package com.example.journal.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.journal.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityStatsBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final RecyclerView RecyclerViewStats;

  @NonNull
  public final EditText datePickerFrom;

  @NonNull
  public final EditText datePickerTo;

  @NonNull
  public final Button disciplines;

  @NonNull
  public final Button group;

  @NonNull
  public final ConstraintLayout main;

  @NonNull
  public final Button schedule;

  @NonNull
  public final Spinner spinnerDisciplines;

  @NonNull
  public final Button stats;

  @NonNull
  public final TextView textView10;

  @NonNull
  public final TextView textView11;

  @NonNull
  public final TextView textView12;

  @NonNull
  public final TextView textView7;

  @NonNull
  public final TextView textView8;

  @NonNull
  public final TextView textView9;

  private ActivityStatsBinding(@NonNull ConstraintLayout rootView,
      @NonNull RecyclerView RecyclerViewStats, @NonNull EditText datePickerFrom,
      @NonNull EditText datePickerTo, @NonNull Button disciplines, @NonNull Button group,
      @NonNull ConstraintLayout main, @NonNull Button schedule, @NonNull Spinner spinnerDisciplines,
      @NonNull Button stats, @NonNull TextView textView10, @NonNull TextView textView11,
      @NonNull TextView textView12, @NonNull TextView textView7, @NonNull TextView textView8,
      @NonNull TextView textView9) {
    this.rootView = rootView;
    this.RecyclerViewStats = RecyclerViewStats;
    this.datePickerFrom = datePickerFrom;
    this.datePickerTo = datePickerTo;
    this.disciplines = disciplines;
    this.group = group;
    this.main = main;
    this.schedule = schedule;
    this.spinnerDisciplines = spinnerDisciplines;
    this.stats = stats;
    this.textView10 = textView10;
    this.textView11 = textView11;
    this.textView12 = textView12;
    this.textView7 = textView7;
    this.textView8 = textView8;
    this.textView9 = textView9;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityStatsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityStatsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_stats, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityStatsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.RecyclerViewStats;
      RecyclerView RecyclerViewStats = ViewBindings.findChildViewById(rootView, id);
      if (RecyclerViewStats == null) {
        break missingId;
      }

      id = R.id.datePickerFrom;
      EditText datePickerFrom = ViewBindings.findChildViewById(rootView, id);
      if (datePickerFrom == null) {
        break missingId;
      }

      id = R.id.datePickerTo;
      EditText datePickerTo = ViewBindings.findChildViewById(rootView, id);
      if (datePickerTo == null) {
        break missingId;
      }

      id = R.id.disciplines;
      Button disciplines = ViewBindings.findChildViewById(rootView, id);
      if (disciplines == null) {
        break missingId;
      }

      id = R.id.group;
      Button group = ViewBindings.findChildViewById(rootView, id);
      if (group == null) {
        break missingId;
      }

      ConstraintLayout main = (ConstraintLayout) rootView;

      id = R.id.schedule;
      Button schedule = ViewBindings.findChildViewById(rootView, id);
      if (schedule == null) {
        break missingId;
      }

      id = R.id.spinnerDisciplines;
      Spinner spinnerDisciplines = ViewBindings.findChildViewById(rootView, id);
      if (spinnerDisciplines == null) {
        break missingId;
      }

      id = R.id.stats;
      Button stats = ViewBindings.findChildViewById(rootView, id);
      if (stats == null) {
        break missingId;
      }

      id = R.id.textView10;
      TextView textView10 = ViewBindings.findChildViewById(rootView, id);
      if (textView10 == null) {
        break missingId;
      }

      id = R.id.textView11;
      TextView textView11 = ViewBindings.findChildViewById(rootView, id);
      if (textView11 == null) {
        break missingId;
      }

      id = R.id.textView12;
      TextView textView12 = ViewBindings.findChildViewById(rootView, id);
      if (textView12 == null) {
        break missingId;
      }

      id = R.id.textView7;
      TextView textView7 = ViewBindings.findChildViewById(rootView, id);
      if (textView7 == null) {
        break missingId;
      }

      id = R.id.textView8;
      TextView textView8 = ViewBindings.findChildViewById(rootView, id);
      if (textView8 == null) {
        break missingId;
      }

      id = R.id.textView9;
      TextView textView9 = ViewBindings.findChildViewById(rootView, id);
      if (textView9 == null) {
        break missingId;
      }

      return new ActivityStatsBinding((ConstraintLayout) rootView, RecyclerViewStats,
          datePickerFrom, datePickerTo, disciplines, group, main, schedule, spinnerDisciplines,
          stats, textView10, textView11, textView12, textView7, textView8, textView9);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
