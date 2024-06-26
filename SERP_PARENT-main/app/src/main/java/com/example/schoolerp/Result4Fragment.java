package com.example.schoolerp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Result4Fragment extends Fragment {

    private Button button211, button212, button213, button214, button21, button215, button216, button217, button218, buttone21;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the fragment layout
        View view = inflater.inflate(R.layout.fragment_result4, container, false);

        // Initialize buttons
        button211 = view.findViewById(R.id.button211);
        button212 = view.findViewById(R.id.button212);
        button213 = view.findViewById(R.id.button213);
        button214 = view.findViewById(R.id.button214);
        button21 = view.findViewById(R.id.button21);
        button215 = view.findViewById(R.id.button215);
        button216 = view.findViewById(R.id.button216);
        button217 = view.findViewById(R.id.button217);
        button218 = view.findViewById(R.id.button218);
        buttone21 = view.findViewById(R.id.buttone21);

        // Set onClickListeners for each button
        button211.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MarksCardFragment.class);
                startActivity(intent);
            }
        });

        button212.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MarksCardFragment.class);
                startActivity(intent);
            }
        });

        button213.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MarksCardFragment.class);
                startActivity(intent);
            }
        });

        button214.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MarksCardFragment.class);
                startActivity(intent);
            }
        });

        button21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MarksCardFragment.class);
                startActivity(intent);
            }
        });

        button215.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MarksCardFragment.class);
                startActivity(intent);
            }
        });

        button216.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MarksCardFragment.class);
                startActivity(intent);
            }
        });

        button217.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MarksCardFragment.class);
                startActivity(intent);
            }
        });

        button218.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MarksCardFragment.class);
                startActivity(intent);
            }
        });

        buttone21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MarksCardFragment.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
