package com.example.detect.data.model

data class PackageUIState(
    val pkg: Package,
    var hasIssue: Boolean,
    var issueType: String?,
    var simulationStopped: Boolean = false
)