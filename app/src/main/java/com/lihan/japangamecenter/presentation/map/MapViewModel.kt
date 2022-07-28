package com.lihan.japangamecenter.presentation.map

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lihan.japangamecenter.domain.location.LocationTracker
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(
    private val locationTracker: LocationTracker
)  : ViewModel(){
    companion object{
        val TAG = "MapViewModel"
    }
    fun getLocation() {
        viewModelScope.launch {
            locationTracker.getLocation()?.let {
                Log.d(TAG, "getLocation: ${it.latitude}")
                Log.d(TAG, "getLocation: ${it.longitude}")
            }
        }
    }


}