package com.lihan.japangamecenter.presentation

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*
import com.lihan.japangamecenter.data.UiEvent
import com.lihan.japangamecenter.presentation.map.MapScreen
import com.lihan.japangamecenter.presentation.map.MapViewModel
import com.lihan.japangamecenter.ui.theme.JapanGameCenterTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel : MapViewModel by viewModels()
    private lateinit var permissionLauncher : ActivityResultLauncher<Array<String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ){
            viewModel.getLocation()
        }
        permissionLauncher.launch(
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        )

        setContent {
            JapanGameCenterTheme {
                val state = viewModel.state
                val cameraPositionState = rememberCameraPositionState()
                val mylocationMarkerState = rememberMarkerState()

                LaunchedEffect(key1 = true){
                    viewModel.uiEvent.collect {  event ->
                        when(event){
                            is UiEvent.LocationGet->{
                                cameraPositionState.position = CameraPosition.fromLatLngZoom(
                                    event.latLng,
                                    16f
                                )
                                mylocationMarkerState.position = event.latLng
                            }
                        }
                    }
                }

                Box(
                    modifier = Modifier.fillMaxSize()
                ){
                    GoogleMap(
                        modifier = Modifier.matchParentSize(),
                        cameraPositionState = cameraPositionState
                    ){
                        Marker(
                                state = mylocationMarkerState,
                                title = "Me",
                                snippet = "Snippet"
                            )
                        }
                    }


                }
            }
        }

}
