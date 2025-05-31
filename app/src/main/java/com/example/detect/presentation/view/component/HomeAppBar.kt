package com.example.detect.presentation.view.component

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.detect.ui.theme.PrimaryColor

@Composable
fun HomeAppBar(){
    Box(
        Modifier
            .fillMaxWidth()
            .height(110.dp)
            .clip(RoundedCornerShape(bottomEnd = 70.dp , bottomStart = 70.dp))
            .background(PrimaryColor),
        contentAlignment = Alignment.Center){
        Row(verticalAlignment = Alignment.CenterVertically , horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            Icon(
                imageVector = Icons.Filled.Menu,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.clickable {  }
            )
            CustomText("Order tracking" , Color.White , 22)
            Icon(
                imageVector = Icons.Filled.Notifications,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.clickable {  }
            )
        }
    }
}