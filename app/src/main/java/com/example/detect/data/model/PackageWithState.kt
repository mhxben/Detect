package com.example.detect.data.model

data class PackageWithState(
    val pkg: Package,
    val panne: PanneState?,
    val lat: Double,
    val lon: Double
)