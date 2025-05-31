package com.example.detect.presentation.view.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mapbox.geojson.Point
import com.mapbox.maps.extension.compose.MapboxMap
import com.mapbox.maps.extension.compose.animation.viewport.rememberMapViewportState

@Composable
fun MapboxMapView() {
    Box(modifier = Modifier.fillMaxSize()) {
        MapboxMap(
            modifier = Modifier.fillMaxSize(), // Ensure full size
            mapViewportState = rememberMapViewportState {
                setCameraOptions {
                    zoom(4.0) // Adjust zoom if needed
                    center(Point.fromLngLat(-98.0, 39.5)) // Center of USA
                    pitch(0.0)
                    bearing(0.0)
                }
            }
        )
    }
}
