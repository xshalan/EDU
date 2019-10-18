package com.example.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentLessonsListBinding extends ViewDataBinding {
  @NonNull
  public final RecyclerView lessonsRecyclerView;

  protected FragmentLessonsListBinding(Object _bindingComponent, View _root, int _localFieldCount,
      RecyclerView lessonsRecyclerView) {
    super(_bindingComponent, _root, _localFieldCount);
    this.lessonsRecyclerView = lessonsRecyclerView;
  }

  @NonNull
  public static FragmentLessonsListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_lessons_list, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentLessonsListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentLessonsListBinding>inflateInternal(inflater, com.example.myapplication.R.layout.fragment_lessons_list, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentLessonsListBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_lessons_list, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentLessonsListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentLessonsListBinding>inflateInternal(inflater, com.example.myapplication.R.layout.fragment_lessons_list, null, false, component);
  }

  public static FragmentLessonsListBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static FragmentLessonsListBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentLessonsListBinding)bind(component, view, com.example.myapplication.R.layout.fragment_lessons_list);
  }
}
