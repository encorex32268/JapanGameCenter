package com.lihan.japangamecenter.presentation.map

import android.location.Location
import com.lihan.japangamecenter.R
import com.lihan.japangamecenter.data.map.model.GameCenter

data class MapState(
    val location : Location? = null,
    val stores : List<GameCenter> = emptyList(),
    val displayStore : GameCenter = GameCenter("Name","Address",0.0,0.0,"Mark", R.drawable.taito_store)
)
