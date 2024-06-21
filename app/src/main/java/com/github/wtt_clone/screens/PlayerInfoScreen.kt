package com.github.wtt_clone.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.github.wtt_clone.BoldText
import com.github.wtt_clone.PlayerData

@Composable
fun PlayerInfoScreen(
    navController: NavController,
    name: String,
    ranking: String,
    points: String,
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            BoldText(text = name)
            BoldText(text = ranking)
            BoldText(text = points)
        }
    }
}