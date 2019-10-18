package com.example.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.example.myapplication.data.adapters.OnLessonClickListener;
import com.example.myapplication.data.model.LessonModel;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemLessonHolderBinding extends ViewDataBinding {
  @NonNull
  public final ImageView lessonHolderClosedImage;

  @NonNull
  public final ImageView lessonHolderCompleteImage;

  @NonNull
  public final TextView lessonHolderProgress;

  @Bindable
  protected LessonModel mLesson;

  @Bindable
  protected OnLessonClickListener mOnLessonClick;

  protected ItemLessonHolderBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView lessonHolderClosedImage, ImageView lessonHolderCompleteImage,
      TextView lessonHolderProgress) {
    super(_bindingComponent, _root, _localFieldCount);
    this.lessonHolderClosedImage = lessonHolderClosedImage;
    this.lessonHolderCompleteImage = lessonHolderCompleteImage;
    this.lessonHolderProgress = lessonHolderProgress;
  }

  public abstract void setLesson(@Nullable LessonModel lesson);

  @Nullable
  public LessonModel getLesson() {
    return mLesson;
  }

  public abstract void setOnLessonClick(@Nullable OnLessonClickListener onLessonClick);

  @Nullable
  public OnLessonClickListener getOnLessonClick() {
    return mOnLessonClick;
  }

  @NonNull
  public static ItemLessonHolderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_lesson_holder, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemLessonHolderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemLessonHolderBinding>inflateInternal(inflater, com.example.myapplication.R.layout.item_lesson_holder, root, attachToRoot, component);
  }

  @NonNull
  public static ItemLessonHolderBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_lesson_holder, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemLessonHolderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemLessonHolderBinding>inflateInternal(inflater, com.example.myapplication.R.layout.item_lesson_holder, null, false, component);
  }

  public static ItemLessonHolderBinding bind(@NonNull View view) {
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
  public static ItemLessonHolderBinding bind(@NonNull View view, @Nullable Object component) {
    return (ItemLessonHolderBinding)bind(component, view, com.example.myapplication.R.layout.item_lesson_holder);
  }
}
