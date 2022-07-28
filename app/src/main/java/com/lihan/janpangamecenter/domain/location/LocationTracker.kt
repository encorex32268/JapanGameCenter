package com.lihan.janpangamecenter.domain.location

import android.location.Location

interface LocationTracker {
    suspend fun getLocation() : Location?
}