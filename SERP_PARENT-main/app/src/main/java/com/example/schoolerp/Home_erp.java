package com.example.schoolerp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.schoolerp.apiservices.ApiService;
import com.example.schoolerp.controller.Controller;
import com.example.schoolerp.databinding.ActivityHomeErpBinding;
import com.google.android.material.navigation.NavigationView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class Home_erp extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityHomeErpBinding binding;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomeErpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.appBarHomeErp.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        // Initialize navigation components
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_attendance, R.id.nav_transport, R.id.nav_contact, R.id.nav_about, R.id.nav_logout)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home_erp);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        // Check if activity is started from notification
        handleNotificationIntent(getIntent());

        Controller crobj = Controller.getInstance();
        // Initialize Retrofit service
        apiService = crobj.getApiService();

        SharedPreferences spf = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String token = spf.getString("AccessToken", " ");
       token = "Bearer "+token;
        apiService.getStudentDetails(token).enqueue(new Callback<ProfileResponse>() {


            @Override
            public void onResponse(Call<ProfileResponse> call, Response<ProfileResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() == null) {
                        Toast.makeText(Home_erp.this, "Response is null", Toast.LENGTH_SHORT).show();

                    } else if (response.body().getfName() == null) {
                        Toast.makeText(Home_erp.this, "First name is null", Toast.LENGTH_SHORT).show();

                    }else{
                        Toast.makeText(Home_erp.this, "Firstname: " + response.body().getfName(), Toast.LENGTH_SHORT).show();

                    }

                } else {
                    Toast.makeText(Home_erp.this, "response message: " + response.message() + "", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ProfileResponse> call, Throwable t) {
                Toast.makeText(Home_erp.this, "Failed to fetch student details"+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleNotificationIntent(intent);
    }

    private void handleNotificationIntent(Intent intent) {
        if (intent != null && intent.hasExtra("notification_action")) {
            // Check if the notification action is to navigate to NotificationFragment
            String action = intent.getStringExtra("notification_action");
            if ("navigate_to_notification_fragment".equals(action)) {
                // Navigate to NotificationFragment
                Navigation.findNavController(this, R.id.nav_host_fragment_content_home_erp)
                        .navigate(R.id.nav_notification);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.nav_logout){
            SharedPreferences.Editor editor= getSharedPreferences("MyPrefs", MODE_PRIVATE).edit();
            editor.clear();
            editor.apply();
            Intent iHome = new Intent(Home_erp.this, LoginActivity.class);
            startActivity(iHome);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home_erp);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
