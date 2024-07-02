package com.example.schoolerp;

        import android.app.FragmentManager;
        import android.app.FragmentTransaction;
        import android.os.Bundle;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.core.graphics.Insets;
        import androidx.core.view.ViewCompat;
        import androidx.core.view.WindowInsetsCompat;
        import androidx.activity.EdgeToEdge;
        import com.example.schoolerp.databinding.ActivityStudentTrackingBinding;
        import com.example.schoolerp.ui.home.HomeFragment;

public class StudentTracking extends AppCompatActivity {

    private ActivityStudentTrackingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityStudentTrackingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        binding.navView1.setOnClickListener(item ->{

            switch (item.getItemId()){

                case R.id.nav_map:
                    replaceFragment(new MapstudentFragment());
                    break;
                case R.id.nav_function:
                    break;
                case R.id.nav_settings:
                    break;
            }

            return true;
        });
    }

    public void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit() ;
    }
}
