package com.github.wtt_clone.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemsIndexed
import com.github.wtt_clone.MainViewModel
import com.github.wtt_clone.R
import com.kevinnzou.compose.core.paginglist.widget.PagingListContainer
import com.kevinnzou.compose.core.paginglist.widget.itemPaging

@Composable
fun LatestScreen(navController: NavController, viewModel: MainViewModel = hiltViewModel()) {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                val pagerData = viewModel.pager.collectAsLazyPagingItems()
                PagingListContainer(pagingData = pagerData) {
                    LazyColumn {
                        item {
                            Text(
                                text = "Raw PagingList",
                                modifier = Modifier
                                    .height(40.dp)
                                    .fillParentMaxWidth()
                                    .padding(top = 15.dp),
                                textAlign = TextAlign.Center
                            )
                        }
                        itemsIndexed(pagerData) { _, value ->
                            PagingContent(value)
                        }
                        itemPaging(pagerData)
                    }
                }
            }
        }
}
@Composable
fun PagingContent(value: String?) {
    Text(
        text = "$value",
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        textAlign = TextAlign.Center
    )
}