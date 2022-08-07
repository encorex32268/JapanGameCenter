package com.lihan.japangamecenter.presentation.map

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.maps.model.LatLng
import com.lihan.japangamecenter.data.Taito
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

    init {
        getAllGameCenter()
    }

    private fun getAllGameCenter() {
        //LoadAllGameCenter
        state = state.copy(
            stores = Taito.jsontest
        )
    }


    fun getLocation() {
        viewModelScope.launch {
            locationTracker.getLocation()?.let {
                _uiEvent.send(UiEvent.LocationUpdate(LatLng(it.latitude,it.longitude)))
            }
        }
    }

    fun onEvent(event: MapEvent){
        when(event){
            is MapEvent.OnLocationChanged->{
                getLocation()
            }
            is MapEvent.OnClickStoreMark->{
                state = state.copy(
                    displayStore = event.gameCenter
                )
                viewModelScope.launch {
                    _uiEvent.send(UiEvent.OnGameStoreMarkClick)
                }
            }
        }
    }


}