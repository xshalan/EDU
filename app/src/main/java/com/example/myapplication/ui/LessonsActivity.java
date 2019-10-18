package com.example.myapplication.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.myapplication.R;
import com.example.myapplication.ui.fragment.LessonsListFragment;

public class LessonsActivity extends AppCompatActivity {


    @Override
    protected void onStart() {
        super.onStart();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.lessonListFragment,new LessonsListFragment()).commit();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons);

    }
}
