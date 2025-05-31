package com.example.detect.presentation.view.component

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.detect.ui.theme.PrimaryColor

@Composable
fun AuthBox(text : String , image: Int ,onClick: ()-> Unit){
    Box(
        Modifier
            .background(Color.White)
            .clickable { onClick() }
            .fillMaxWidth()
            .height(50.dp)
            .border(1.dp, PrimaryColor, RoundedCornerShape(10.dp))
        , contentAlignment = Alignment.Center
    ){
        StaticRow {
            Image(painter = painterResource(id = image),null , modifier = Modifier.size(24.dp))
            PrimaryText(text, PrimaryColor)
        }
    }
}