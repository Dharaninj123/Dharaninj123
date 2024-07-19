package com.example.schoolerp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.schoolerp.apiservices.ApiService;
import com.example.schoolerp.apiservices.modelclass.AadhaarCardResponse;
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

    private HomeErpViewModel homeErpViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomeErpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        homeErpViewModel=new ViewModelProvider(this).get(HomeErpViewModel.class);
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


                    }else{
                        View view = binding.navView.getHeaderView(0);
                        homeErpViewModel.profileResponseMutableLiveData.postValue(response.body());
                        if (response.body().getFirstname()!=null){
                          TextView textView=(TextView)view.findViewById(R.id.nameView);
                          textView.setText(response.body().getFirstname());

                        }

                        // To retrieve the value from SharedPreferences
                        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                        String mobileNumber = sharedPreferences.getString("MobileNumber", "");

                        if (!mobileNumber.isEmpty()){
                            TextView textView=(TextView)view.findViewById(R.id.numberView);
                            textView.setText(mobileNumber);

                        }

                        Toast.makeText(Home_erp.this, "Firstname: " + response.body().getSection(), Toast.LENGTH_SHORT).show();

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

    private void getAadharCardData(){
        SharedPreferences spf = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String token = spf.getString("AccessToken","");
        token = "Bearer" + token;
        apiService.getAadharCard(token).enqueue(new Callback<AadhaarCardResponse>() {

            @Override
            public void onResponse(Call<AadhaarCardResponse> call, Response<AadhaarCardResponse> response) {
                if (response.isSuccessful()){
                    if(response.body() == null) {
                        Toast.makeText(Home_erp.this,"Response of null", Toast.LENGTH_SHORT).show();
                    }else{
                        homeErpViewModel.aadharCardResponseMutableLiveData.postValue(response.body().getAadhar_document_url());
                    }
                }else{
                    Toast.makeText(Home_erp.this,"response message:" + response.message()+"",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AadhaarCardResponse> call, Throwable t) {

            }
        });
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

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.nav_logout) {
            SharedPreferences.Editor editor = getSharedPreferences("MyPrefs", MODE_PRIVATE).edit();
            editor.clear();
            editor.apply();
            Intent iHome = new Intent(Home_erp.this, LoginActivity.class);
            startActivity(iHome);
            finish();
        }

            if(item.getItemId()==R.id.nav_about){
                Navigation.findNavController(this,R.id.nav_host_fragment_content_home_erp)
                        .navigate(R.id.nav_about);
            }


        return super.onOptionsItemSelected(item);
    }*/

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home_erp);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
