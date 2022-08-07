package com.lihan.japangamecenter.presentation.map

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.BottomSheetState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*
import com.lihan.japangamecenter.data.UiEvent
import com.lihan.japangamecenter.data.map.model.GameCenter
import com.lihan.japangamecenter.presentation.map.components.StoreCard
import com.lihan.japangamecenter.ui.LocalSpacing
import dev.chrisbanes.snapper.ExperimentalSnapperApi
import dev.chrisbanes.snapper.SnapperFlingBehaviorDefaults
import dev.chrisbanes.snapper.SnapperLayoutInfo
import dev.chrisbanes.snapper.rememberSnapperFlingBehavior
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@ExperimentalSnapperApi
@Composable
fun MapScreen(
    viewModel: MapViewModel = hiltViewModel(),
    sheetState  : BottomSheetState
) {
    val cameraPositionState = rememberCameraPositionState()
    val mylocationMarkerState = rememberMarkerState()
    val scope = rememberCoroutineScope()
    LaunchedEffect(key1 = true){
        viewModel.uiEvent.collect {  event ->
            when(event){
                is UiEvent.LocationUpdate->{
                    cameraPositionState.position = CameraPosition.fromLatLngZoom(event.latLng, 16f)
                    mylocationMarkerState.position = event.latLng
                }
                is UiEvent.OnGameStoreMarkClick->{
                    scope.launch {
                        if (sheetState.isExpanded){
                            sheetState.collapse()
                            sheetState.expand()
                        }else{
                            sheetState.expand()
                        }
                    }

                }
            }
        }
    }


    var uiSettings by remember {
        mutableStateOf(MapUiSettings(
            zoomControlsEnabled = false,
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
            },
            onMapClick = {

            }
        ){
            Marker(
                icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE),
                state = mylocationMarkerState,
                title = "Me",
                snippet = "Snippet",
            )
            viewModel.state.stores.forEach { store ->
                Marker(
                    icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW),
                    state = MarkerState(
                        LatLng(
                            store.lat,store.lng
                        )
                    ),
                    title = store.name,
                    snippet = "${store.name}Snippet",
                    onClick = {
                        viewModel.onEvent(MapEvent.OnClickStoreMark(store))
                        true
                    }
                )

            }



        }

    }


}
