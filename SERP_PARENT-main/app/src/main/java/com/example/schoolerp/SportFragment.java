package com.example.schoolerp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.schoolerp.apiservices.modelclass.SportModelClass;

import java.util.ArrayList;
import java.util.List;

public class SportFragment extends Fragment {

    private RecyclerView recyclerView;
    private SportAdapter sportAdapter;
    private List<SportModelClass> sportModelClassList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sport, container, false);

        recyclerView = view.findViewById(R.id.recycler_viewSport);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        sportModelClassList = new ArrayList<>();
        sportModelClassList.add(new SportModelClass("Select", "Select")); // Default values
        // Add more items as needed

        sportAdapter = new SportAdapter(getContext(), sportModelClassList);
        recyclerView.setAdapter(sportAdapter);

        return view;
    }
}
