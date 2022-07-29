package com.lihan.japangamecenter.presentation.map

import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*
import com.lihan.japangamecenter.data.UiEvent
import com.lihan.japangamecenter.presentation.map.components.StoreCard
import com.lihan.japangamecenter.ui.LocalSpacing
import dev.chrisbanes.snapper.ExperimentalSnapperApi
import dev.chrisbanes.snapper.SnapperLayoutInfo
import dev.chrisbanes.snapper.rememberSnapperFlingBehavior
import kotlinx.coroutines.launch

@ExperimentalSnapperApi
@Composable
fun MapScreen(
    viewModel: MapViewModel = hiltViewModel()
) {
    val cameraPositionState = rememberCameraPositionState()
    val mylocationMarkerState = rememberMarkerState()
    val spacing = LocalSpacing.current
    LaunchedEffect(key1 = true){
        viewModel.uiEvent.collect {  event ->
            when(event){
                is UiEvent.LocationGet->{
                    cameraPositionState.position = CameraPosition.fromLatLngZoom(event.latLng, 16f)
                    mylocationMarkerState.position = event.latLng
                }
            }
        }
    }

    var uiSettings by remember {
        mutableStateOf(MapUiSettings(
            zoomControlsEnabled = true,
            myLocationButtonEnabled = true
        )
        )
    }
    var properties by remember {
        mutableStateOf(MapProperties(
            mapType = MapType.NORMAL,
            isMyLocationEnabled = true
        ))
    }
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        GoogleMap(
            modifier = Modifier.matchParentSize(),
            cameraPositionState = cameraPositionState,
            uiSettings = uiSettings,
            properties = properties,
            onMyLocationButtonClick = {
                viewModel.onEvent(MapEvent.OnLocationChanged)
                true
            }
        ){
            Marker(
                icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE),
                state = mylocationMarkerState,
                title = "Me",
                snippet = "Snippet"
            )
        }

    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomEnd
    ){

        val listState = rememberLazyListState()

        val flingBehavior = rememberSnapperFlingBehavior(
            lazyListState = listState
        )
//        val config = LocalConfiguration.current
//        val screenWidth = config.screenWidthDp
        LazyRow(
            state = listState,
            flingBehavior = flingBehavior
        ){
            items(10){
                StoreCard()
            }
        }
    }


}
