package com.example.schoolerp.ui.home;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.schoolerp.HomeErpViewModel;
import com.example.schoolerp.LoginActivity;
import com.example.schoolerp.R;
import com.example.schoolerp.StudentTracking;
import com.example.schoolerp.ui.home.HomeFragment;

public class HomeFragment extends Fragment {

    private HomeErpViewModel homeErpViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        // Load the AadhaarFragment
        loadFragment(new HomeFragment());

        // Find the CardView with ID "name"
        CardView nameCardView = root.findViewById(R.id.name);

        // Set OnClickListener for the "name" CardView
        nameCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProfileFragment(v);
            }
        });

        // Find the CardView with ID "transport"
        CardView transportCardView = root.findViewById(R.id.transport);

        // Set OnClickListener for the "transport" CardView
        transportCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTransportFragment(v);
            }
        });

        CardView studentTrackCardView = root.findViewById(R.id.attendance);

        studentTrackCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAttendanceFragment(v);
            }
        });

        CardView sportsAndCulturalCardView = root.findViewById(R.id.sportsandcultural);

        sportsAndCulturalCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSportCulturalFragment(v);
            }
        });

        CardView studentTrackingCardView = root.findViewById(R.id.studentTracking);

        studentTrackingCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), StudentTracking.class);
                startActivity(intent);
            }
        });

        return root;
    }

    private void loadFragment(Fragment fragment) {
        // Create a fragment transaction
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Replace the content of the container with the new fragment
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Uncomment and use the ViewModel if needed
        // homeErpViewModel = new ViewModelProvider(getActivity()).get(HomeErpViewModel.class);
        // homeErpViewModel.profileResponseMutableLiveData.observe(getViewLifecycleOwner(), profileResponse -> {
        //     if (profileResponse != null) {
        //         openProfileFragment(view);
        //     }
        // });
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_items, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_logout) {
            SharedPreferences.Editor editor = requireActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE).edit();
            editor.clear();
            editor.apply();
            Intent iHome = new Intent(requireActivity(), LoginActivity.class);
            startActivity(iHome);
            requireActivity().finish();
            return true;
        } else if (id == R.id.nav_about) {
            NavHostFragment.findNavController(this).navigate(R.id.nav_about);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void openProfileFragment(View view) {
        // Replace the current fragment with FragmentProfile
        Navigation.findNavController(view).navigate(R.id.action_nav_home_to_profileFragment);
    }

    private void openTransportFragment(View view) {
        Navigation.findNavController(view).navigate(R.id.action_nav_home_to_transport);
    }

    private void openAttendanceFragment(View view) {
        Navigation.findNavController(view).navigate(R.id.action_nav_home_to_attendance);
    }

    private void openStudentTracking(View view) {
        Navigation.findNavController(view).navigate(R.id.action_nav_home_to_studenttracking);
    }

    private void openResultFragment(View view) {
        Navigation.findNavController(view).navigate(R.id.action_nav_home_to_result);
    }

    private void openSportCulturalFragment(View view) {
        Navigation.findNavController(view).navigate(R.id.action_nav_home_to_sportsandcultural);
    }
}
