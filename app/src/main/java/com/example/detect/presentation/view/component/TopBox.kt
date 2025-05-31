package com.example.detect.presentation.view.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.detect.R
import com.example.detect.ui.theme.PrimaryColor

@Composable
fun TopBox(){
    Box(
        Modifier.fillMaxWidth()
            .height(250.dp)
            .clip(RoundedCornerShape(
                bottomEnd = 70.dp , bottomStart = 70.dp
            ))
            .background(PrimaryColor)
        , contentAlignment = Alignment.Center
    ){
        CustomColumn {
            Image(
                painter = painterResource( id = R.drawable.logo),
                contentDescription = null,
                Modifier.size(100.dp)
            )
            CustomText("Welcome to Tawssil" , Color.White , 25)
            CustomText("Please log in using the form below." , Color.White , 12)
        }
    }
}