package com.example.myapplication.data.model;

import java.io.Serializable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "Lessons")
public class LessonModel implements Serializable{

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "lessonTitle")
    private String title;

    @ColumnInfo(name = "isOpen")
    private boolean isOpen = false ;

    @ColumnInfo(name = "progress")
    private int progress  = 0 ;

    @ColumnInfo(name = "isDone")
    private boolean isDone = false;

    @ColumnInfo(name = "isProgressable")
    private boolean isProgressable = false ;

    public LessonModel(int id, String title) {
        this.id = id;
        this.title = title;
    }


    public boolean isDone() {
        return isDone;
    }

    public boolean isProgressable() {
        return isProgressable;
    }

    public void setProgressable(boolean progressable) {
        this.isProgressable = progressable;
    }

    public void setDone(boolean done) {
        isDone = done;

        if(isDone)
            isProgressable = false;
        else
            isProgressable = true ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
        if(open)
            isProgressable = true;

    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }
}
