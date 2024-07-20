package com.example.schoolerp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.schoolerp.databinding.ProfileStudentBinding;

public class Student_Profile extends Fragment {

    private HomeErpViewModel homeErpViewModel;
    private ProfileStudentBinding binding;

    public Student_Profile() {
        // Required empty public constructor
    }

    public static Student_Profile newInstance() {
        return new Student_Profile();
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

    private void openProfileFragment(View view) {
        // Replace the current fragment with FragmentProfile
        Navigation.findNavController(view).navigate(R.id.action_nav_home_to_profileFragment);
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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment using ViewBinding
        binding = ProfileStudentBinding.inflate(inflater, container, false);
        View view = inflater.inflate(R.layout.profile_student, container, false);
        homeErpViewModel = new ViewModelProvider(requireActivity()).get(HomeErpViewModel.class);

        // Set an OnClickListener for the TextView
        binding.viewMore.setOnClickListener(v -> NavHostFragment.findNavController(Student_Profile.this)
                .navigate(R.id.fragment_more_student_details));

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        homeErpViewModel.profileResponseMutableLiveData.observe(getViewLifecycleOwner(), profileResponse -> {
            if (profileResponse != null) {
                Log.i("ProfileResponse",profileResponse.toString());
                if(profileResponse.getFirstname()!=null){
                    binding.nameinput.setText(profileResponse.getFirstname());
                }
                if(profileResponse.getAdmission_number()!=null){
                    binding.admissionNoinput.setText(profileResponse.getAdmission_number());
                }
                if(profileResponse.getDateOfAdmission()!=null){
                    binding.admissionDateinput.setText(profileResponse.getDateOfAdmission());
                }
                if(profileResponse.getRollNo()!=null){
                    binding.rollNoinput.setText(profileResponse.getRollNo());
                }
                if(profileResponse.getSection()!=null){
                    binding.sectioninput.setText(profileResponse.getSection());
                }
                if(profileResponse.getGender()!=null){
                    binding.genderinput.setText(profileResponse.getGender());
                }
                if(profileResponse.getEducationMedium()!=null){
                    binding.mediuminput.setText(profileResponse.getEducationMedium());
                }
                if(profileResponse.getStream()!=null){
                    binding.boardinput.setText(profileResponse.getStream());
                }
                if(profileResponse.getAddress()!=null){
                    binding.addressinput.setText(profileResponse.getAddress());
                }
            }
        });
    }
}
