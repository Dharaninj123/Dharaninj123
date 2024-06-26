package com.example.schoolerp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Result2Fragment extends Fragment {

    private Button button231, button232, button233, button234, button23, button235, button236, button237, button238, buttone23;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the fragment layout
        return inflater.inflate(R.layout.fragment_result2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initialize buttons
        button231 = view.findViewById(R.id.button231);
        button232 = view.findViewById(R.id.button232);
        button233 = view.findViewById(R.id.button233);
        button234 = view.findViewById(R.id.button234);
        button23 = view.findViewById(R.id.button23);
        button235 = view.findViewById(R.id.button235);
        button236 = view.findViewById(R.id.button236);
        button237 = view.findViewById(R.id.button237);
        button238 = view.findViewById(R.id.button238);
        buttone23 = view.findViewById(R.id.buttone23);

        // Set click listeners
        button231.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToMarkscard();
            }
        });

        button232.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToMarkscard();
            }
        });

        button233.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToMarkscard();
            }
        });

        button234.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToMarkscard();
            }
        });

        button23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToMarkscard();
            }
        });

        button235.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToMarkscard();
            }
        });

        button236.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToMarkscard();
            }
        });

        button237.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToMarkscard();
            }
        });

        button238.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToMarkscard();
            }
        });

        buttone23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToMarkscard();
            }
        });
    }

    // Method to navigate to markscard activity
    private void navigateToMarkscard() {
        Intent intent = new Intent(getActivity(), MarksCardFragment.class);
        startActivity(intent);
    }
}
