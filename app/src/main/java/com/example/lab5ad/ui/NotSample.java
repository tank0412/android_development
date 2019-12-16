package com.example.lab5ad.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab5ad.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NotSample extends Fragment {
    private StudentAdapter studentAdapter;

    private RecyclerView recyclerView;
    private List<studentData> studentDataList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_not_sample, container, false);
        recyclerView = root.findViewById(R.id.recycler_view);
        studentAdapter = new StudentAdapter(studentDataList);
        RecyclerView.LayoutManager manager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(studentAdapter);
        StudentDataPrepare();
        return root;
    }

    private void StudentDataPrepare() {
        studentData data = new studentData("sai", 25);
        studentDataList.add(data);
        data = new studentData("sai", 25);
        studentDataList.add(data);
        data = new studentData("raghu", 20);
        studentDataList.add(data);
        data = new studentData("raj", 28);
        studentDataList.add(data);
        data = new studentData("amar", 15);
        studentDataList.add(data);
        data = new studentData("bapu", 19);
        studentDataList.add(data);
        data = new studentData("chandra", 52);
        studentDataList.add(data);
        data = new studentData("deraj", 30);
        studentDataList.add(data);
        data = new studentData("eshanth", 28);
        studentDataList.add(data);
        Collections.sort(studentDataList, new Comparator<studentData>() {
            @Override
            public int compare(studentData o1, studentData o2) {
                return o1.name.compareTo(o2.name);
            }
        });
    }
}