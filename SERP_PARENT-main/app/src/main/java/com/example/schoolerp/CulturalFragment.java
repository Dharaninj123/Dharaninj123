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

import com.example.schoolerp.apiservices.modelclass.CulturalModelClass;

import java.util.ArrayList;
import java.util.List;

public class CulturalFragment extends Fragment {

    private RecyclerView recyclerView;
    private CulturalAdapter culturalAdapter;
    private List<CulturalModelClass> culturalModelClassList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cultural, container, false);

        recyclerView = view.findViewById(R.id.recycler_viewCulture);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        culturalModelClassList = new ArrayList<>();
        culturalModelClassList.add(new CulturalModelClass("Select", "Select")); // Default values
        // Add more items as needed

        culturalAdapter = new CulturalAdapter(getContext(), culturalModelClassList);
        recyclerView.setAdapter(culturalAdapter);

        return view;
    }
}
