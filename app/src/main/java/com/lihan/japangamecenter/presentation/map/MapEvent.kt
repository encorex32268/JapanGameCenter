package com.lihan.japangamecenter.presentation.map

import com.lihan.japangamecenter.data.map.model.GameCenter


sealed class MapEvent{
    object OnLocationChanged : MapEvent()
    data class OnClickStoreMark(val gameCenter: GameCenter) : MapEvent()

}
