package com.example.schoolerp;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.util.SparseArray;
import com.example.schoolerp.databinding.ActivityStudentTrackingBinding;


public class StudentTracking extends AppCompatActivity {

    private ActivityStudentTrackingBinding binding;
    private SparseArray<Fragment> fragmentMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityStudentTrackingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Initialize the fragment map
        fragmentMap = new SparseArray<>();
        fragmentMap.put(R.id.nav_map, new MapstudentFragment());
        fragmentMap.put(R.id.nav_function, new MoreFunctionsFragment());
        fragmentMap.put(R.id.nav_settings, new SettingsFragment());

        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        replaceFragment(fragmentMap.get(R.id.nav_map)); // Default fragment

        binding.navView1.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = fragmentMap.get(item.getItemId());
            if (selectedFragment != null) {
                replaceFragment(selectedFragment);
            }
            return true;
        });
    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}
