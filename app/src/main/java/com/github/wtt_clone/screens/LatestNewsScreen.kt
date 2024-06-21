package com.github.wtt_clone.screens

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.core.content.ContextCompat.startActivity
import androidx.core.os.bundleOf
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import androidx.paging.compose.itemsIndexed
import coil.compose.SubcomposeAsyncImage
import com.github.wtt_clone.BoldText
import com.github.wtt_clone.Constants
import com.github.wtt_clone.DescriptionText
import com.github.wtt_clone.viewmodels.LatestNewsViewModel
import com.github.wtt_clone.LatestPageData
import com.github.wtt_clone.NewsDetailActivity
import com.github.wtt_clone.ScoreCardData
import com.github.wtt_clone.familyBioSans
import com.github.wtt_clone.ui.theme.orange
import com.kevinnzou.compose.core.paginglist.widget.PagingListContainer
import com.kevinnzou.compose.core.paginglist.widget.itemPaging

@Composable
fun LatestScreen(
    navController: NavController,
    viewModel: LatestNewsViewModel = hiltViewModel(),
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val c = LocalContext.current
            val latestNewsPagerData = viewModel.latestNewsPager.collectAsLazyPagingItems()
            val scorePagerData = viewModel.scoreCardPager.collectAsLazyPagingItems()
            PagingListContainer(pagingData = latestNewsPagerData) {
                LazyColumn {
                    item {
                        LazyRow {
                            items(scorePagerData) {
                                it?.let {
                                    LiveScoreCard(it)
                                }
                            }
                        }
                    }
                    itemsIndexed(latestNewsPagerData) { _, value ->
                        value?.let {
                            ScrollableContent(it) {
                                startActivity(
                                    c,
                                    Intent(c, NewsDetailActivity::class.java),
                                    bundleOf()
                                )
                            }
                        }

                    }
                    itemPaging(latestNewsPagerData)
                }
            }
        }
    }
}

@Composable
fun LiveScoreCard(scoreCard: ScoreCardData) {
    Row(
        modifier = Modifier
            .heightIn(max = 120.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .widthIn(max = 100.dp)
                .padding(2.dp)
                .border(color = Color.Gray, width = 1.dp)
                .padding(8.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Bottom
        ) {
            ImageLoaderWTT(
                url = scoreCard.match.countryFlag,
                modifier = Modifier.size(width = 20.dp, height = 15.dp)
            )
            Spacer(modifier = Modifier.padding(vertical = 4.dp))
            BoldText(text = scoreCard.match.title, size = 14.sp)
        }
        Column(
            modifier = Modifier
                .heightIn(min = 120.dp)
                .padding(2.dp)
                .border(color = Color.Gray, width = 1.dp)
                .padding(8.dp),
        ) {
            BoldText(text = scoreCard.currentMatch.day, size = 10.sp)
            DescriptionText(text = scoreCard.currentMatch.title, size = 10.sp, color = Color.Cyan)
            HorizontalDivider(
                color = Color.Cyan,
                thickness = 2.dp,
                modifier = Modifier.fillMaxWidth()
            )
            Row {
                ImageLoaderWTT(
                    url = scoreCard.playersData1.flag,
                    modifier = Modifier
                        .size(width = 20.dp, height = 15.dp)
                        .padding(2.dp)
                )
                ImageLoaderWTT(
                    url = scoreCard.playersData1.flag,
                    modifier = Modifier
                        .size(width = 20.dp, height = 15.dp)
                        .padding(2.dp)
                )
                BoldText(
                    text = scoreCard.playersData1.players.uppercase(),
                    size = 8.sp
                )
            }
            Row {
                ImageLoaderWTT(
                    url = scoreCard.playersData2.flag,
                    modifier = Modifier
                        .size(width = 20.dp, height = 15.dp)
                        .padding(2.dp)
                )
                ImageLoaderWTT(
                    url = scoreCard.playersData2.flag,
                    modifier = Modifier
                        .size(width = 20.dp, height = 15.dp)
                        .padding(2.dp)
                )
                BoldText(
                    text = scoreCard.playersData2.players.uppercase(),
                    size = 8.sp
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .widthIn(max = 80.dp)
                .padding(2.dp)
                .border(color = Color.Gray, width = 1.dp)
                .padding(8.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Bottom
        ) {
            Box(
                modifier = Modifier
                    .sizeIn(24.dp,24.dp)
                    .background(
                        color = Color.Cyan,
                        shape = RoundedCornerShape(50)
                    )
                    .padding(4.dp),
                contentAlignment = Alignment.Center
            ) {
                BoldText(text = "${(1..30).random()}", size = 12.sp, color = Color.Black)
            }
            Spacer(modifier = Modifier.padding(vertical = 4.dp))
            Row(
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.Bottom
            ) {
                BoldText(
                    text = "More Matches",
                    size = 10.sp, color = Color.Cyan,
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    modifier = Modifier.size(10.dp),
                    tint = Color.Cyan,
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "icon"
                )
            }
        }
    }
}


@Composable
fun ScrollableContent(
    pageData: LatestPageData,
    modifier: Modifier = Modifier,
    navigateToReadMorePage: () -> Unit
) {
    Column(modifier = Modifier.padding(vertical = 16.dp)) {
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
        Row(modifier = Modifier
            .padding(top = 16.dp, start = 8.dp, bottom = 32.dp)
            .clickable {
                navigateToReadMorePage()
            }) {
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

