package com.example.detect.presentation.view.component.model

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType

data class OutlinedTextFieldClass(
    val value: String,
    val onValueChange: (String) -> Unit,
    val label: String,
    val keyboardType: KeyboardType = KeyboardType.Text,
    val isPasswordField: Boolean = false,
    val isPasswordVisible: Boolean = false,
    val leadingIcon: ImageVector? = null,
    val onVisibilityToggle: (() -> Unit)? = null,
    val isDropdown: Boolean = false,
    val dropdownItems: List<String> = emptyList(),
    val isDatePicker: Boolean = false,
    val onDatePicked: (() -> Unit)? = null
)