package com.github.wtt_clone.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.github.wtt_clone.BoldText
import com.github.wtt_clone.R

@Composable
fun ProfileScreen(navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Image(
            alpha = 0.33f,
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.bg),
            contentDescription = "bg"
        )
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            BoldText(
                text = "Welcome to Wtt!".uppercase(),
                size = 60.sp,
                modifier = Modifier.padding(8.dp)
            )
            BoldText(
                text = "Join community".uppercase(),
                size = 25.sp,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}