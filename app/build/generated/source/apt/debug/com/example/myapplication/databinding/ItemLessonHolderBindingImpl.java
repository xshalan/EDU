package com.example.myapplication.databinding;
import com.example.myapplication.R;
import com.example.myapplication.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemLessonHolderBindingImpl extends ItemLessonHolderBinding implements com.example.myapplication.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final androidx.cardview.widget.CardView mboundView0;
    @NonNull
    private final android.widget.TextView mboundView1;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemLessonHolderBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }
    private ItemLessonHolderBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[3]
            , (android.widget.ImageView) bindings[2]
            , (android.widget.TextView) bindings[4]
            );
        this.lessonHolderClosedImage.setTag(null);
        this.lessonHolderCompleteImage.setTag(null);
        this.lessonHolderProgress.setTag(null);
        this.mboundView0 = (androidx.cardview.widget.CardView) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.TextView) bindings[1];
        this.mboundView1.setTag(null);
        setRootTag(root);
        // listeners
        mCallback1 = new com.example.myapplication.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.lesson == variableId) {
            setLesson((com.example.myapplication.data.model.LessonModel) variable);
        }
        else if (BR.onLessonClick == variableId) {
            setOnLessonClick((com.example.myapplication.data.adapters.OnLessonClickListener) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setLesson(@Nullable com.example.myapplication.data.model.LessonModel Lesson) {
        this.mLesson = Lesson;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.lesson);
        super.requestRebind();
    }
    public void setOnLessonClick(@Nullable com.example.myapplication.data.adapters.OnLessonClickListener OnLessonClick) {
        this.mOnLessonClick = OnLessonClick;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.onLessonClick);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        int lessonOpenViewGONEViewVISIBLE = 0;
        boolean lessonDone = false;
        int lessonDoneViewVISIBLEViewGONE = 0;
        int lessonProgressableViewVISIBLEViewGONE = 0;
        java.lang.String lessonTitle = null;
        java.lang.String integerToStringLessonProgressJavaLangString = null;
        java.lang.String integerToStringLessonProgress = null;
        com.example.myapplication.data.model.LessonModel lesson = mLesson;
        int lessonProgress = 0;
        boolean lessonOpen = false;
        com.example.myapplication.data.adapters.OnLessonClickListener onLessonClick = mOnLessonClick;
        boolean lessonProgressable = false;

        if ((dirtyFlags & 0x5L) != 0) {



                if (lesson != null) {
                    // read lesson.done
                    lessonDone = lesson.isDone();
                    // read lesson.title
                    lessonTitle = lesson.getTitle();
                    // read lesson.progress
                    lessonProgress = lesson.getProgress();
                    // read lesson.open
                    lessonOpen = lesson.isOpen();
                    // read lesson.progressable
                    lessonProgressable = lesson.isProgressable();
                }
            if((dirtyFlags & 0x5L) != 0) {
                if(lessonDone) {
                        dirtyFlags |= 0x40L;
                }
                else {
                        dirtyFlags |= 0x20L;
                }
            }
            if((dirtyFlags & 0x5L) != 0) {
                if(lessonOpen) {
                        dirtyFlags |= 0x10L;
                }
                else {
                        dirtyFlags |= 0x8L;
                }
            }
            if((dirtyFlags & 0x5L) != 0) {
                if(lessonProgressable) {
                        dirtyFlags |= 0x100L;
                }
                else {
                        dirtyFlags |= 0x80L;
                }
            }


                // read lesson.done ? View.VISIBLE : View.GONE
                lessonDoneViewVISIBLEViewGONE = ((lessonDone) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
                // read Integer.toString(lesson.progress)
                integerToStringLessonProgress = java.lang.Integer.toString(lessonProgress);
                // read lesson.open ? View.GONE : View.VISIBLE
                lessonOpenViewGONEViewVISIBLE = ((lessonOpen) ? (android.view.View.GONE) : (android.view.View.VISIBLE));
                // read lesson.progressable ? View.VISIBLE : View.GONE
                lessonProgressableViewVISIBLEViewGONE = ((lessonProgressable) ? (android.view.View.VISIBLE) : (android.view.View.GONE));


                // read (Integer.toString(lesson.progress)) + ("%")
                integerToStringLessonProgressJavaLangString = (integerToStringLessonProgress) + ("%");
        }
        // batch finished
        if ((dirtyFlags & 0x5L) != 0) {
            // api target 1

            this.lessonHolderClosedImage.setVisibility(lessonOpenViewGONEViewVISIBLE);
            this.lessonHolderCompleteImage.setVisibility(lessonDoneViewVISIBLEViewGONE);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.lessonHolderProgress, integerToStringLessonProgressJavaLangString);
            this.lessonHolderProgress.setVisibility(lessonProgressableViewVISIBLEViewGONE);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView1, lessonTitle);
        }
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.mboundView0.setOnClickListener(mCallback1);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // onLessonClick != null
        boolean onLessonClickJavaLangObjectNull = false;
        // lesson
        com.example.myapplication.data.model.LessonModel lesson = mLesson;
        // onLessonClick
        com.example.myapplication.data.adapters.OnLessonClickListener onLessonClick = mOnLessonClick;



        onLessonClickJavaLangObjectNull = (onLessonClick) != (null);
        if (onLessonClickJavaLangObjectNull) {



            onLessonClick.onClick(lesson);
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): lesson
        flag 1 (0x2L): onLessonClick
        flag 2 (0x3L): null
        flag 3 (0x4L): lesson.open ? View.GONE : View.VISIBLE
        flag 4 (0x5L): lesson.open ? View.GONE : View.VISIBLE
        flag 5 (0x6L): lesson.done ? View.VISIBLE : View.GONE
        flag 6 (0x7L): lesson.done ? View.VISIBLE : View.GONE
        flag 7 (0x8L): lesson.progressable ? View.VISIBLE : View.GONE
        flag 8 (0x9L): lesson.progressable ? View.VISIBLE : View.GONE
    flag mapping end*/
    //end
}