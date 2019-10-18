package com.example.myapplication.data.adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myapplication.ui.fragment.PdfFragment;
import com.example.myapplication.R;
import com.example.myapplication.data.model.LessonModel;
import com.example.myapplication.databinding.ItemLessonHolderBinding;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

public class LessonsRecyclerAdapter  extends RecyclerView.Adapter<LessonsRecyclerAdapter.ViewHolder> implements OnLessonClickListener {

    private List<LessonModel> lessons;
    private Context context;
    private OnLessonClickListener onLessonClickListener;


    public LessonsRecyclerAdapter(List<LessonModel> lessons, Context context) {
        this.lessons = lessons;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemLessonHolderBinding itemLessonHolderBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_lesson_holder,parent,false);

        return new ViewHolder(itemLessonHolderBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LessonModel lesson = lessons.get(position);
        holder.itemLessonHolderBinding.setLesson(lesson);
        holder.itemLessonHolderBinding.setOnLessonClick(this);

    }

    @Override
    public int getItemCount() {
        return lessons.size();
    }

    @Override
    public void onClick(LessonModel lessonModel) {
        if(lessonModel.isDone() || lessonModel.isOpen()){
            Toast.makeText(context,"open lesson",Toast.LENGTH_LONG).show();
            Bundle arguments = new Bundle();
            arguments.putSerializable( "lesson" ,lessonModel);
            Fragment fragment = new PdfFragment();
            fragment.setArguments(arguments);
            FragmentTransaction ft = ((FragmentActivity)context).getSupportFragmentManager().beginTransaction();
            ft.addToBackStack("LessonsListFragment");
            ft.replace(R.id.lessonListFragment,fragment).commit();
        }else{
            Toast.makeText(context,"Please finish the previous lesson",Toast.LENGTH_LONG).show();
        }


    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemLessonHolderBinding itemLessonHolderBinding;
        public ViewHolder(@NonNull ItemLessonHolderBinding itemLessonHolderBinding) {
            super(itemLessonHolderBinding.getRoot());
            this.itemLessonHolderBinding = itemLessonHolderBinding;
        }
    }
}
