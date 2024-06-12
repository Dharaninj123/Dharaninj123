package com.example.schoolerp.utils

import androidx.lifecycle.MutableLiveData
import com.example.schoolerp.ProfileResponse

object StudentResponseData {
    var profileResponse:MutableLiveData< ProfileResponse?> = MutableLiveData(null)
}