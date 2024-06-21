package com.github.wtt_clone.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.github.wtt_clone.BoldText
import com.github.wtt_clone.DescriptionText
import com.github.wtt_clone.PlayerData
import com.github.wtt_clone.ui.theme.orange
import com.github.wtt_clone.viewmodels.PlayersViewModel

@Composable
fun PlayerInfoScreen(
    navController: NavController,
    name: String,
    ranking: String,
    points: String,
    country: String,
    viewModel: PlayersViewModel = hiltViewModel()
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val url by remember {
            mutableStateOf(viewModel.generateRandomProfilePicture())
        }
        val flag by remember {
            mutableStateOf(viewModel.generateRandomFlag())
        }
        val desc by remember {
            mutableStateOf(viewModel.generateRandomDescription())
        }
        Box(modifier = Modifier.fillMaxSize()) {
            ImageLoaderWTT(
                url = url,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.Black.copy(alpha = 0.35f)),
                contentAlignment = Alignment.BottomStart
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier.padding(8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start
                        ) {
                            BoldText(
                                text = "#${ranking}",
                                size = 40.sp,
                                color = orange,
                                modifier = Modifier.weight(1f)
                            )
                            BoldText(text = points.plus(" Points").uppercase(), color = orange)
                        }
                    }
                }

                Column {
                    Row(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Column {
                            ImageLoaderWTT(
                                url = flag,
                                modifier = Modifier.size(width = 25.dp, height = 20.dp)
                            )
                            BoldText(
                                modifier = Modifier.padding(top = 8.dp),
                                text = country,
                                size = 10.sp,
                            )
                        }
                        DescriptionText(
                            text = name,
                            size = 25.sp,
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                    }
                    DescriptionText(
                        text = desc,
                        size = 16.sp,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }

        }
    }
}