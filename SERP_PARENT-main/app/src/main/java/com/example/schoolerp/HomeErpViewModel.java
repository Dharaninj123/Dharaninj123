package com.example.schoolerp;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeErpViewModel extends ViewModel {
     MutableLiveData<ProfileResponse> profileResponseMutableLiveData = new MutableLiveData<>();

     MutableLiveData<String> aadharCardResponseMutableLiveData = new MutableLiveData<>();

}
