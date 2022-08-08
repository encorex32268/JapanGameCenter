package com.lihan.japangamecenter.presentation

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lihan.japangamecenter.presentation.map.MapScreen
import com.lihan.japangamecenter.presentation.map.MapViewModel
import com.lihan.japangamecenter.presentation.map.components.StoreCard
import com.lihan.japangamecenter.ui.theme.JapanGameCenterTheme
import dagger.hilt.android.AndroidEntryPoint
import dev.chrisbanes.snapper.ExperimentalSnapperApi
import kotlinx.coroutines.launch


@ExperimentalMaterialApi
@ExperimentalSnapperApi
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
                        val sheetState = rememberBottomSheetState(
                            initialValue = BottomSheetValue.Collapsed
                        )
                        val scaffoldState = rememberBottomSheetScaffoldState(
                            bottomSheetState = sheetState
                        )
                        val scope = rememberCoroutineScope()

                        BottomSheetScaffold(
                            scaffoldState =scaffoldState,
                            sheetContent = {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ){
                                    val store = viewModel.state.displayStore
                                    StoreCard(
                                        store = store,
                                        OnCloseClick = {
                                            if (sheetState.isExpanded){
                                                scope.launch {
                                                    sheetState.collapse()
                                                }
                                            }
                                        },
                                        OnItemClick = {
                                            //Google map
                                            val url = "https://www.google.com/maps/search/?api=1&query=${it.lat}%2C${it.lng}"
                                            Intent(
                                                Intent.ACTION_VIEW,
                                                Uri.parse(url)
                                            ).also { intent ->
                                                startActivity(intent)
                                            }
                                        }
                                    )
                                }

                            },
                            sheetPeekHeight = 0.dp,
                            sheetGesturesEnabled = true
                        ){
                            MapScreen(
                                sheetState = sheetState
                            )
                        }
                    }
                }
            }
}
