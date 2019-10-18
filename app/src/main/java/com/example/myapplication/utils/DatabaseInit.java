package com.example.myapplication.utils;


import android.os.AsyncTask;

import com.example.myapplication.data.model.LessonModel;
import com.example.myapplication.data.database.LessonsDatabase;

import androidx.annotation.NonNull;

public class DatabaseInit {

    private static final String TAG = DatabaseInit.class.getName();
    public static final String OVERALL_PROGRESS_KEY = "progress";
    public static int overAllProgress = 1 ;
    public static int calculateProgress(int i){
        int c = 100 * i;
        return c/12;
    }

    private static LessonModel addLesson(final LessonsDatabase db,LessonModel lessonModel){
        db.lessonsDAO().insertLesson(lessonModel);
        return lessonModel;
    }

    public static void populateAsync(@NonNull final LessonsDatabase db) {
        PopulateDbAsync task = new PopulateDbAsync(db);
        task.execute();
    }

    public static void populateSync(@NonNull final LessonsDatabase db) {
        initLessonsData(db);
    }



    private static void initLessonsData(LessonsDatabase db){
        LessonModel one = new LessonModel(1,"Lesson one here");
        one.setOpen(true);
        addLesson(db,one);

        for(int i=2;i<=10;i++){
            LessonModel lessonModel = new LessonModel(i,"Put Lesson here");
            lessonModel.setDone(false);
            lessonModel.setOpen(false);
            lessonModel.setProgressable(false);
            addLesson(db,lessonModel);
        }

    }

    private static class PopulateDbAsync extends AsyncTask<Void,Void,Void>{

        private final LessonsDatabase db;

        private PopulateDbAsync(LessonsDatabase db) {
            this.db = db;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            initLessonsData(db);
            return null;
        }
    }




}
