package com.example.myapplication.data.database;

import android.content.Context;

import com.example.myapplication.data.model.LessonModel;
import com.example.myapplication.data.dao.LessonsDAO;
import com.example.myapplication.utils.DatabaseInit;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {LessonModel.class},version = 1,exportSchema = false)
public abstract class LessonsDatabase extends RoomDatabase {

    public abstract LessonsDAO lessonsDAO();
    private static LessonsDatabase instance;

    public static LessonsDatabase getInstance(final Context context){
        if(instance == null){
            synchronized (LessonsDatabase.class){
                if (instance == null){
                    instance = Room.databaseBuilder(context.getApplicationContext()
                    ,LessonsDatabase.class,"lessons_database")
                            .addCallback(new RoomDatabase.Callback(){
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);
                                    DatabaseInit.populateAsync(instance);
                                }
                            })
                            .allowMainThreadQueries()
                            .build();

                }
            }
        }



        return instance;
    }


}
