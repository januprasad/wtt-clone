package com.github.wtt_clone.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemsIndexed
import com.github.wtt_clone.BoldText
import com.github.wtt_clone.DescriptionText
import com.github.wtt_clone.PlayerData
import com.github.wtt_clone.Screens
import com.github.wtt_clone.ui.theme.orange
import com.github.wtt_clone.viewmodels.PlayersViewModel
import com.kevinnzou.compose.core.paginglist.widget.PagingListContainer

@Composable
fun PlayersScreen(
    navController: NavController,
    viewModel: PlayersViewModel = hiltViewModel()
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            val playersPagerData = viewModel.playersPager.collectAsLazyPagingItems()
            PagingListContainer(pagingData = playersPagerData) {
                LazyColumn {
                    itemsIndexed(playersPagerData) { _, value ->
                        value?.let {
                            PlayersCard(it) {
                                navController.navigate("player_info_screen/${it.name}/${it.ranking}/${it.points}/${it.country}")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun PlayersCard(player: PlayerData, navigateToPlayerDetails: (PlayerData) -> Unit) {
    Box {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            ImageLoaderWTT(
                url = player.profileImage,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .height(140.dp)
                    .width(120.dp)
            )
        }
        Column(modifier = Modifier.padding(16.dp)) {
            ImageLoaderWTT(
                url = player.countryFlag,
                modifier = Modifier.size(width = 20.dp, height = 15.dp)
            )
            BoldText(
                text = player.country,
                size = 10.sp,
                modifier = Modifier.padding(top = 8.dp)
            )
            BoldText(
                text = player.ranking,
                size = 40.sp,
                color = orange,
                modifier = Modifier.padding(top = 2.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color.Black.copy(alpha = 0.29f)
                    )
                    .padding(6.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                DescriptionText(
                    text = player.name,
                    modifier = Modifier
                        .weight(1f)
                        .padding(top = 8.dp)
                )
                Row(
                    modifier = Modifier.clickable {
                        navigateToPlayerDetails(player)
                    },
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    BoldText(
                        text = player.points,
                        size = 20.sp,
                        color = orange,
                        modifier = Modifier.padding(top = 2.dp)
                    )
                    Icon(
                        modifier = Modifier.size(24.dp),
                        tint = orange,
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = "icon"
                    )
                }
            }
        }

    }
}
