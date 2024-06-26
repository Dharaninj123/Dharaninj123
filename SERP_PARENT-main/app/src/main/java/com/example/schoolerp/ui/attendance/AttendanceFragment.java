package com.example.schoolerp.ui.attendance;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.schoolerp.Attendance2;
import com.example.schoolerp.R;
import com.example.schoolerp.databinding.FragmentAttendanceBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AttendanceFragment extends Fragment {

    private FragmentAttendanceBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAttendanceBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        AttendanceViewModel attendanceViewModel = new ViewModelProvider(this).get(AttendanceViewModel.class);

        // Prepare the list with a hint
        List<String> months = new ArrayList<>();
        months.add(getString(R.string.spinner_hint2));  // Hint
        months.addAll(Arrays.asList(getResources().getStringArray(R.array.months_array)));

        // Set up the Spinner with month options and hint
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),
                R.layout.spinner_item, months);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        binding.spinner.setAdapter(adapter);

        // Set initial selection to the hint (first item)
        binding.spinner.setSelection(0);

        // Handle button click
        binding.submitButton.setOnClickListener(v -> {
            // Handle button click here
            String selectedMonth = binding.spinner.getSelectedItem().toString();
            if (selectedMonth.equals(getString(R.string.spinner_hint2))) {
                Toast.makeText(getContext(), "Please select a month", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "Selected month: " + selectedMonth, Toast.LENGTH_SHORT).show();
                navigateToAttendance2();
            }
        });

        return root;
    }

    private void navigateToAttendance2() {
        getParentFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new Attendance2())
                .addToBackStack(null)  // Optional: Adds transaction to back stack
                .commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
