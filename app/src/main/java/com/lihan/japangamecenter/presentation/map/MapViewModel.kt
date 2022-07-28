package com.lihan.japangamecenter.presentation.map

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.maps.model.LatLng
import com.lihan.japangamecenter.data.UiEvent
import com.lihan.japangamecenter.domain.location.LocationTracker
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(
    private val locationTracker: LocationTracker
)  : ViewModel(){

    companion object{
        val TAG = "MapViewModel"
    }

    var state by mutableStateOf(MapState())
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun getLocation() {
        viewModelScope.launch {

            locationTracker.getLocation()?.let {
                state = state.copy(
                    location = it
                )
                Log.d(TAG, "getLocation: ${it.latitude}")
                Log.d(TAG, "getLocation: ${it.longitude}")
                _uiEvent.send(UiEvent.LocationGet(LatLng(it.latitude,it.longitude)))
            }
        }
    }


}