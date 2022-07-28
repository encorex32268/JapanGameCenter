package com.lihan.janpangamecenter.di

import android.app.Application
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.lihan.janpangamecenter.data.location.DefaultLocationTracker
import com.lihan.janpangamecenter.domain.location.LocationTracker
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideFusedLocationProviderClient(app:Application) : FusedLocationProviderClient{
        return LocationServices.getFusedLocationProviderClient(app)
    }

}