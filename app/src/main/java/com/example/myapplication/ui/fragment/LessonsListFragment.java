package com.example.myapplication.ui.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.data.database.LessonsDatabase;
import com.example.myapplication.data.adapters.LessonsRecyclerAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class LessonsListFragment extends Fragment {

    private RecyclerView recyclerView;

    public LessonsListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lessons_list, container, false);
        recyclerView = view.findViewById(R.id.lessonsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        LessonsRecyclerAdapter adapter = new LessonsRecyclerAdapter(
                LessonsDatabase.getInstance(getContext()).lessonsDAO().getAllLessons(),getContext());

        recyclerView.setAdapter(adapter);

        return view;
    }

}
