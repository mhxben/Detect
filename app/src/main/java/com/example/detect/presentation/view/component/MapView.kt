package com.example.detect.presentation.view.component

import android.graphics.BitmapFactory
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.detect.R
import com.example.detect.data.model.Package
import com.example.detect.data.model.PanneState
import com.mapbox.geojson.Point
import com.mapbox.maps.extension.compose.MapEffect
import com.mapbox.maps.extension.compose.MapboxMap
import com.mapbox.maps.extension.compose.animation.viewport.rememberMapViewportState
import com.mapbox.maps.plugin.annotation.annotations
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationOptions
import com.mapbox.maps.plugin.annotation.generated.createPointAnnotationManager

@Composable
fun MapboxMapView(pkg: Package, lat: Double, lon: Double, panneState: PanneState?) {
    val context = LocalContext.current

    val hasIssue = listOfNotNull(
        panneState?.humidity,
        panneState?.temperature,
        panneState?.vibration
    ).any { it == -1 }

    val iconRes = if (hasIssue) R.drawable.carpanne else R.drawable.car

    val iconId = if (hasIssue) "marker-issue" else "marker-normal"

    val bitmap = BitmapFactory.decodeResource(context.resources, iconRes)

    val viewportState = rememberMapViewportState {
        setCameraOptions {
            zoom(5.0)
            center(Point.fromLngLat(lon, lat))
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        MapboxMap(
            modifier = Modifier.fillMaxSize(),
            mapViewportState = viewportState
        ) {
            MapEffect(key1 = panneState) { mapView ->
                val annotationApi = mapView.annotations
                val pointAnnotationManager = annotationApi.createPointAnnotationManager()
                pointAnnotationManager.deleteAll()

                mapView.getMapboxMap().getStyle { style ->
                    style.removeStyleImage("marker-normal")
                    style.removeStyleImage("marker-issue")
                    style.addImage(iconId, bitmap)
                }

                val point = Point.fromLngLat(lon, lat)
                val options = PointAnnotationOptions()
                    .withPoint(point)
                    .withIconImage(iconId)

                pointAnnotationManager.create(options)
            }
        }
    }
}
