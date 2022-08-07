package com.lihan.japangamecenter.data

import com.google.android.gms.maps.model.LatLng
import com.lihan.japangamecenter.data.map.model.GameCenter

sealed class UiEvent{
    data class LocationUpdate(val latLng: LatLng) : UiEvent()
    object  OnGameStoreMarkClick : UiEvent()
}
