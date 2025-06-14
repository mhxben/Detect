package com.example.detect.presentation.view.component

import android.graphics.BitmapFactory
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.detect.R
import com.mapbox.geojson.Point
import com.mapbox.maps.extension.compose.MapEffect
import com.mapbox.maps.extension.compose.MapboxMap
import com.mapbox.maps.extension.compose.animation.viewport.rememberMapViewportState
import com.mapbox.maps.plugin.annotation.annotations
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationOptions
import com.mapbox.maps.plugin.annotation.generated.createPointAnnotationManager
import com.example.detect.data.model.PackageWithState

@Composable
fun MapboxMapView(
    packages: List<PackageWithState>,
    onMarkerClick: (PackageWithState) -> Unit
) {
    val context = LocalContext.current

    val viewportState = rememberMapViewportState {
        setCameraOptions {
            zoom(5.0)
            center(Point.fromLngLat(packages.firstOrNull()?.lon ?: 0.0, packages.firstOrNull()?.lat ?: 0.0))
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        MapboxMap(
            modifier = Modifier.fillMaxSize(),
            mapViewportState = viewportState
        ) {
            MapEffect(key1 = packages) { mapView ->
                val annotationApi = mapView.annotations
                val pointAnnotationManager = annotationApi.createPointAnnotationManager()
                pointAnnotationManager.deleteAll()

                packages.forEach { packageWithState ->
                    val hasIssue = listOfNotNull(
                        packageWithState.panne?.humidity,
                        packageWithState.panne?.temperature,
                        packageWithState.panne?.vibration
                    ).any { it == 1 }

                    val iconRes = if (hasIssue) R.drawable.carpanne else R.drawable.car
                    val iconId = if (hasIssue) "marker-issue-${packageWithState.pkg.id}" else "marker-normal-${packageWithState.pkg.id}"

                    val bitmap = BitmapFactory.decodeResource(context.resources, iconRes)

                    mapView.getMapboxMap().getStyle { style ->
                        style.removeStyleImage(iconId)
                        style.addImage(iconId, bitmap)
                    }

                    val point = Point.fromLngLat(packageWithState.lon, packageWithState.lat)
                    val options = PointAnnotationOptions()
                        .withPoint(point)
                        .withIconImage(iconId)

                    val annotation = pointAnnotationManager.create(options)

                    pointAnnotationManager.addClickListener {
                        onMarkerClick(packageWithState)
                        true
                    }
                }
            }
        }
    }
}
