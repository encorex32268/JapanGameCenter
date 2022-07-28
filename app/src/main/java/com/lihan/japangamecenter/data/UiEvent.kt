package com.lihan.japangamecenter.data

import com.google.android.gms.maps.model.LatLng

sealed class UiEvent{
    data class LocationGet(val latLng: LatLng) : UiEvent()
}
