package com.github.wtt_clone.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.github.wtt_clone.DescriptionText
import com.github.wtt_clone.VideoData
import com.github.wtt_clone.viewmodels.VideosViewModel
import com.kevinnzou.compose.core.paginglist.widget.PagingListContainer

@Composable
fun AllVideosScreen(viewModel: VideosViewModel = hiltViewModel()) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val pagerData = viewModel.matchHighLightsPager.collectAsLazyPagingItems()
        PagingListContainer(pagingData = pagerData) {
            LazyColumn() {
                items(pagerData) {
                    it?.let {
                        VideoCardRow(
                            it
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun VideoCardRow(videoCard: VideoData) {
    Row(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
        ImageLoaderWTT(
            videoCard.thumb,
            Modifier
                .height(100.dp)
                .width(150.dp)
        )
        DescriptionText(modifier = Modifier.padding(8.dp), text = videoCard.title, maxLines = 2)
    }
}

