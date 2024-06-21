package com.github.wtt_clone.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.github.wtt_clone.DescriptionText
import com.github.wtt_clone.viewmodels.LatestNewsViewModel

@Composable
fun NewsDetailScreen(modifier: Modifier, viewModel: LatestNewsViewModel = hiltViewModel()) {
    Surface(
        modifier = modifier.fillMaxSize(),
    ) {
        val image by remember {
            mutableStateOf(viewModel.randomNewsImage())
        }
        val description by remember {
            mutableStateOf(viewModel.mapAllDescriptions())
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
        ) {

            item {
                ImageLoaderWTT(
                    url = image, modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                )
            }
            item {
                DescriptionText(text = description, modifier = Modifier.padding(8.dp))
            }
        }
    }
}