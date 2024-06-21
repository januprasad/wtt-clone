package com.github.wtt_clone.screens

import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.github.wtt_clone.AllVideosActivity
import com.github.wtt_clone.BoldText
import com.github.wtt_clone.DescriptionText
import com.github.wtt_clone.VideoData
import com.github.wtt_clone.VideosViewModel
import com.github.wtt_clone.ui.theme.orange
import com.kevinnzou.compose.core.paginglist.widget.PagingListContainer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VideoScreen(
    navController: NavController, viewModel: VideosViewModel = hiltViewModel(),
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column {
            var text by remember { mutableStateOf("") } // Query for SearchBar
            var active by remember { mutableStateOf(false) } // Active state for SearchBar
            SearchBar(modifier = Modifier.fillMaxWidth(),
                query = text,
                onQueryChange = {
                    text = it
                },
                onSearch = {
                    active = false
                },
                active = active,
                onActiveChange = {
                    active = false
                },
                placeholder = {
                    Text(text = "Enter your query")
                },
                trailingIcon = {
                    Icon(imageVector = Icons.Default.Search, contentDescription = null)
                }) {

            }
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                item {
                    MatchHighlights(viewModel)
                }
                item {
                    Compilations(viewModel)
                }
                item {
                    PressRelease(viewModel)
                }
                item {
                    BehindTheScenes(viewModel)
                }
                item {
                    PlayerReturns(viewModel)
                }
            }
        }
    }
}

@Composable
fun MatchHighlights(viewModel: VideosViewModel) {
    val pagerData = viewModel.matchHighLightsPager.collectAsLazyPagingItems()
    BoldText(
        text = "Match highlights".uppercase(),
        modifier = Modifier.padding(vertical = 16.dp, horizontal = 8.dp)
    )
    PagingListContainer(pagingData = pagerData) {
        LazyRow(
            modifier = Modifier.sizeIn(maxHeight = 180.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(pagerData) {
                it?.let {
                    VideoCard(it)
                }
            }
        }
    }
    VideoCardBottomControls()
}

@Composable
fun Compilations(viewModel: VideosViewModel) {

    val pagerData = viewModel.compilationsPager.collectAsLazyPagingItems()
    BoldText(
        text = "Compilations".uppercase(),
        modifier = Modifier.padding(vertical = 16.dp, horizontal = 8.dp)
    )
    PagingListContainer(pagingData = pagerData) {
        LazyRow(
            modifier = Modifier.sizeIn(maxHeight = 180.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(pagerData) {
                it?.let {
                    VideoCard(it)
                }
            }
        }
    }
    VideoCardBottomControls()
}

@Composable
fun PressRelease(viewModel: VideosViewModel) {

    val pagerData = viewModel.pressReleasePager.collectAsLazyPagingItems()
    BoldText(
        text = "Press Release".uppercase(),
        modifier = Modifier.padding(vertical = 16.dp, horizontal = 8.dp)
    )
    PagingListContainer(pagingData = pagerData) {
        LazyRow(
            modifier = Modifier.sizeIn(maxHeight = 180.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(pagerData) {
                it?.let {
                    VideoCard(it)
                }
            }
        }
    }
    VideoCardBottomControls()
}

@Composable
fun BehindTheScenes(viewModel: VideosViewModel) {

    val pagerData = viewModel.behindTheScenesPager.collectAsLazyPagingItems()
    BoldText(
        text = "Behind The Scenes".uppercase(),
        modifier = Modifier.padding(vertical = 16.dp, horizontal = 8.dp)
    )
    PagingListContainer(pagingData = pagerData) {
        LazyRow(
            modifier = Modifier.sizeIn(maxHeight = 180.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(pagerData) {
                it?.let {
                    VideoCard(it)
                }
            }
        }
    }
    VideoCardBottomControls()
}

@Composable
fun PlayerReturns(viewModel: VideosViewModel) {
    val pagerData = viewModel.playerReturnsPager.collectAsLazyPagingItems()
    BoldText(
        text = "Player Returns".uppercase(),
        modifier = Modifier.padding(vertical = 16.dp, horizontal = 8.dp)
    )
    PagingListContainer(pagingData = pagerData) {
        LazyRow(
            modifier = Modifier.sizeIn(maxHeight = 180.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(pagerData) {
                it?.let {
                    VideoCard(it)
                }
            }
        }
    }
    VideoCardBottomControls()
}

@Composable
fun VideoCardBottomControls() {
    val c = LocalContext.current
    Row(modifier = Modifier
        .padding(top = 16.dp, start = 8.dp, bottom = 8.dp)
        .clickable {
            ContextCompat.startActivity(
                c,
                Intent(c, AllVideosActivity::class.java),
                bundleOf()
            )
        }) {
        BoldText(
            modifier = Modifier.weight(1f),
            text = "All Videos",
            size = 16.sp,
        )
        Icon(
            tint = orange,
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = "icon"
        )
    }
    HorizontalDivider()
}


@Composable
fun VideoCard(videoCard: VideoData) {
    Column(modifier = Modifier.sizeIn(maxWidth = 150.dp, maxHeight = 180.dp)) {
        ImageLoaderWTT(
            videoCard.thumb,
            Modifier
                .height(100.dp)
                .width(150.dp)
        )
        DescriptionText(modifier = Modifier.padding(8.dp), text = videoCard.title, maxLines = 2)
    }
}
