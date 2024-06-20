package com.github.wtt_clone.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemsIndexed
import coil.compose.SubcomposeAsyncImage
import com.github.wtt_clone.Constants
import com.github.wtt_clone.MainViewModel
import com.github.wtt_clone.LatestPageData
import com.kevinnzou.compose.core.paginglist.widget.PagingListContainer
import com.kevinnzou.compose.core.paginglist.widget.itemPaging

@Composable
fun LatestScreen(navController: NavController, viewModel: MainViewModel = hiltViewModel()) {
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val pagerData = viewModel.pager.collectAsLazyPagingItems()
            PagingListContainer(pagingData = pagerData) {
                LazyColumn {
                    item {
                        Text(
                            text = "Horizontal scroll",
                            modifier = Modifier
                                .height(40.dp)
                                .fillParentMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    }
                    itemsIndexed(pagerData) { _, value ->
//                        PagingContent(value)
                        value?.let {
                            ScrollableContent(it)
                        }

                    }
                    itemPaging(pagerData)
                }
            }
        }
    }
}

@Composable
fun ScrollableContent(pageData: LatestPageData,
                      modifier: Modifier = Modifier) {
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .background(brush = Constants.brush)
        )
        Box(modifier = Modifier.fillMaxWidth())
        {
            ImageLoaderWTT(pageData.image, modifier.height(200.dp))
        }
        Text(text = pageData.title, style = TextStyle.Default.copy(
            fontSize = 24.sp,
        ))

        Text(text = pageData.description, style = TextStyle.Default.copy(
            fontSize = 16.sp,
        ))



    }
}

@Composable
fun ImageLoaderWTT(url: String, modifier: Modifier = Modifier) {
    SubcomposeAsyncImage(
        model = url,
        modifier = modifier
            .fillMaxWidth(),
        contentScale = ContentScale.Crop,
        loading = {
            Box(modifier = modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        },
        contentDescription = "coil_image_content_description",
    )
}

