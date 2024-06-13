package com.example.schoolerp.controller;

import android.util.Log;

import com.example.schoolerp.FCMTokenRequest;
import com.example.schoolerp.MySharedPreferences;
import com.example.schoolerp.apiservices.ApiService;
import com.example.schoolerp.StudentsDetailsResponse;
import com.google.firebase.messaging.FirebaseMessaging;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller {

    private static Controller instance;
    private Retrofit retrofit;
    private static ApiService apiService;
    private MySharedPreferences mySharedPreferences;

    OkHttpClient client;

    private Controller() {
        // Initialize Retrofit
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

        retrofit = new Retrofit.Builder()
                // Ensure the base URL includes the API endpoint
                .baseUrl("http://192.168.0.102/api/account/") // Adjust the base URL accordingly
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        // Create ApiService instance
        apiService = retrofit.create(ApiService.class);
    }

    public static synchronized Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public static ApiService getApiService() {
        return apiService;
    }


    // If you need to create an instance of ApiService with a different class
    public ApiService create(Class<ApiService> apiServiceClass) {
        return retrofit.create(apiServiceClass);
    }
}
