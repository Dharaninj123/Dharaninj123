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

public class Result3Fragment extends Fragment {

    private Button button221, button222, button223, button224, button22, button225, button226, button227, button228, buttone22;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the fragment layout
        View view = inflater.inflate(R.layout.fragment_result3, container, false);

        // Initialize buttons
        button221 = view.findViewById(R.id.button221);
        button222 = view.findViewById(R.id.button222);
        button223 = view.findViewById(R.id.button223);
        button224 = view.findViewById(R.id.button224);
        button22 = view.findViewById(R.id.button22);
        button225 = view.findViewById(R.id.button225);
        button226 = view.findViewById(R.id.button226);
        button227 = view.findViewById(R.id.button227);
        button228 = view.findViewById(R.id.button228);
        buttone22 = view.findViewById(R.id.buttone22);

        // Set onClickListeners for each button
        button221.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MarksCardFragment.class);
                startActivity(intent);
            }
        });

        button222.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MarksCardFragment.class );
                startActivity(intent);
            }
        });

        button223.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MarksCardFragment.class);
                startActivity(intent);
            }
        });

        button224.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MarksCardFragment.class);
                startActivity(intent);
            }
        });

        button22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MarksCardFragment.class);
                startActivity(intent);
            }
        });

        button225.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MarksCardFragment.class);
                startActivity(intent);
            }
        });

        button226.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MarksCardFragment.class);
                startActivity(intent);
            }
        });

        button227.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MarksCardFragment.class);
                startActivity(intent);
            }
        });

        button228.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MarksCardFragment.class);
                startActivity(intent);
            }
        });

        buttone22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MarksCardFragment.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
