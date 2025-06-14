package com.example.detect.presentation.view.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.detect.data.model.PanneState

@Composable
fun IssueInfoCard(
    panne: PanneState,
    onClose: () -> Unit,
    onFix: () -> Unit
) {
    androidx.compose.material3.Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("🚨 Package Problem", style = MaterialTheme.typography.titleLarge)

            if (panne.humidity == 1) Text("• Humidity issue detected")
            if (panne.temperature == 1) Text("• Temperature issue detected")
            if (panne.vibration == 1) Text("• Vibration issue detected")

            Spacer(modifier = Modifier.height(16.dp))

            Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                Button(onClick = onFix) {
                    Text("Fix")
                }
                Button(onClick = onClose) {
                    Text("Close")
                }
            }
        }
    }
}
