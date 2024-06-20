package com.example.schoolerp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AttendanceFragment extends Fragment {

    private Spinner monthSpinner;
    private Button submitButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_attendance, container, false);

        // Initialize the views
        monthSpinner = view.findViewById(R.id.spinner);
        submitButton = view.findViewById(R.id.button);

        // Prepare the list with a hint
        List<String> months = new ArrayList<>();
        months.add(getString(R.string.spinner_hint));  // Hint
        months.addAll(Arrays.asList(getResources().getStringArray(R.array.months_array)));

        // Set up the Spinner with month options and hint
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),
                R.layout.spinner_item, months);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        monthSpinner.setAdapter(adapter);

        // Set initial selection to the hint (first item)
        monthSpinner.setSelection(0);

        // Handle button click
        submitButton.setOnClickListener(v -> {
            // Handle button click here
            String selectedMonth = monthSpinner.getSelectedItem().toString();
            if (selectedMonth.equals(getString(R.string.spinner_hint))) {
                Toast.makeText(getContext(), "Please select a month", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "Selected month: " + selectedMonth, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
