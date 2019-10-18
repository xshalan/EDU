package com.example.myapplication.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.myapplication.R;
import com.example.myapplication.data.database.LessonsDatabase;
import com.example.myapplication.data.dao.LessonsDAO;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private LessonsDAO lessonsDAO;
    public LessonsDatabase lessonsDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button= findViewById(R.id.log);
        lessonsDatabase = new LessonsDatabase() {
            @Override
            public LessonsDAO lessonsDAO() {
                lessonsDAO = lessonsDatabase.lessonsDAO();
                return lessonsDAO;
            }

            @NonNull
            @Override
            protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
                return null;
            }

            @NonNull
            @Override
            protected InvalidationTracker createInvalidationTracker() {
                return null;
            }

            @Override
            public void clearAllTables() {

            }
        };



        openHome();
    }
public void openHome(){

    Intent intent =new Intent(this, home.class);
    startActivity(intent);


}

}
