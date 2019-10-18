package com.example.myapplication.data.dao;

import com.example.myapplication.data.model.LessonModel;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface LessonsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertLesson(LessonModel lessonModel);

    @Delete
    void deleteLesson(LessonModel lessonModel);

    @Query("SELECT * from Lessons")
    List<LessonModel> getAllLessons();

    @Query("SELECT * from Lessons WHERE id = :id ")
    LessonModel getLessonById(int id);

    @Query("UPDATE Lessons SET progress=:progress WHERE id=:id" )
    void updateProgressByLessonId(int progress,int id);

    @Query("UPDATE Lessons SET isOpen=:open WHERE id=:id" )
    void updateOpenByLessonId(boolean open,int id);

    @Query("UPDATE Lessons SET isDone=:done WHERE id=:id" )
    void updateDoneByLessonId(boolean done,int id);

    @Query("UPDATE Lessons SET isProgressable=:progress WHERE id=:id" )
    void updateProgressableByLessonId(boolean progress,int id);
}
