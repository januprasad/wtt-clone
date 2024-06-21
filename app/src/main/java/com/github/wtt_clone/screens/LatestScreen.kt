package com.github.wtt_clone.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemsIndexed
import coil.compose.SubcomposeAsyncImage
import com.github.wtt_clone.BoldText
import com.github.wtt_clone.Constants
import com.github.wtt_clone.DescriptionText
import com.github.wtt_clone.MainViewModel
import com.github.wtt_clone.LatestPageData
import com.github.wtt_clone.familyBioSans
import com.github.wtt_clone.familyHelveticaNeue
import com.github.wtt_clone.ui.theme.orange
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
            val pagerData = viewModel.latestNewsPager.collectAsLazyPagingItems()
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
fun ScrollableContent(
    pageData: LatestPageData,
    modifier: Modifier = Modifier
) {
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .background(brush = Constants.gradientBrush)
        )
        Column(
            verticalArrangement = Arrangement.spacedBy((-10).dp),
        ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                ImageLoaderWTT(pageData.image, modifier.height(200.dp))
            }

            Box(
                modifier = Modifier
                    .zIndex(2f)
                    .padding(bottom = 10.dp, start = 10.dp)
            ) {
                Tag(tag = pageData.tag)
            }
        }

        Column(modifier = Modifier.padding(8.dp)) {
            BoldText(
                text = pageData.title,
            )
            Spacer(modifier = Modifier.padding(vertical = 8.dp))
            DescriptionText(text = pageData.description)
        }
        Row(modifier = Modifier.padding(top = 16.dp, start = 8.dp, bottom = 32.dp)) {
            BoldText(
                color = orange,
                modifier = Modifier.weight(1f),
                text = "Read More",
                size = 16.sp,
            )
            Icon(
                tint = orange,
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "icon"
            )
        }
    }
}

@Composable
fun Tag(tag: String) {
    Box(
        modifier = Modifier
            .wrapContentSize()
            .background(Color.White)
    ) {
        Text(
            modifier = Modifier
                .wrapContentSize()
                .padding(4.dp),
            text = tag,
            color = Color.Black,
            fontWeight = FontWeight.SemiBold,
            style = TextStyle.Default.copy(
                fontSize = 10.sp,
                fontFamily = familyBioSans,
                letterSpacing = 0.5.sp,
                lineHeight = 21.sp,
            )
        )
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

