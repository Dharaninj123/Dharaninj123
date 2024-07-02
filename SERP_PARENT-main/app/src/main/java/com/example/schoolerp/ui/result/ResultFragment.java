package com.example.schoolerp.ui.result;

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

import com.example.schoolerp.R;
import com.example.schoolerp.Result1Fragment;
import com.example.schoolerp.databinding.FragmentResultBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResultFragment extends Fragment {

    private FragmentResultBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentResultBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Initialize the ViewModel

        // Prepare the list with a hint
        List<String> years = new ArrayList<>();
        years.add(getString(R.string.spinner_hint1));  // Hint
        years.addAll(Arrays.asList(getResources().getStringArray(R.array.year_array)));

        // Set up the Spinner with year options and hint
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(),
                R.layout.spinner_item, years);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        binding.spinner.setAdapter(adapter);

        // Set initial selection to the hint (first item)
        binding.spinner.setSelection(0);

        // Handle button click
        binding.button.setOnClickListener(v -> {
            // Handle button click here
            String selectedYear = binding.spinner.getSelectedItem().toString();
            if (selectedYear.equals(getString(R.string.spinner_hint1))) {
                Toast.makeText(requireContext(), "Please select a year", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(requireContext(), "Selected year: " + selectedYear, Toast.LENGTH_SHORT).show();
                navigateToResult1(); // Navigate to Result1 fragment on button click
            }
        });

        return root;
    }

    private void navigateToResult1() {
        getParentFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new Result1Fragment()) // Replace with your desired destination fragment and correct ID
                .addToBackStack(null)  // Optional: Adds transaction to back stack
                .commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // Clean up binding to avoid memory leaks
    }
}
