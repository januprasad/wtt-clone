package com.github.wtt_clone.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemsIndexed
import com.github.wtt_clone.Constants
import com.github.wtt_clone.EventData
import com.github.wtt_clone.EventsViewModel
import com.github.wtt_clone.MainViewModel
import com.github.wtt_clone.R
import com.github.wtt_clone.familyBioSans
import com.kevinnzou.compose.core.paginglist.widget.PagingListContainer
import com.kevinnzou.compose.core.paginglist.widget.itemPaging

@Composable
fun EventsScreen(navController: NavController, viewModel: EventsViewModel = hiltViewModel()) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            val pagerData = viewModel.eventsPager.collectAsLazyPagingItems()
            PagingListContainer(pagingData = pagerData) {
                LazyColumn {
                    itemsIndexed(pagerData) { _, value ->
                        value?.let {
                            EventCards(it)
                        }

                    }
                    itemPaging(pagerData)
                }
            }
        }
    }
}

@Composable
fun EventCards(eventData: EventData) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(
            text = eventData.date,
            style = TextStyle.Default.copy(
                fontSize = 18.sp,
                fontFamily = familyBioSans,
                letterSpacing = 0.5.sp,
            )
        )
        Text(
            text = eventData.title, fontWeight = FontWeight.ExtraBold,
            style = TextStyle.Default.copy(
                fontSize = 24.sp,
                fontFamily = familyBioSans,
                letterSpacing = 0.5.sp,
            )
        )

        Row(modifier = Modifier.padding(top = 8.dp)) {
            ImageLoaderWTT(
                eventData.countryFlag, modifier = Modifier
                    .height(60.dp)
                    .width(100.dp)
            )
            Spacer(modifier = Modifier.padding(8.dp))
            Text(
                text = eventData.description, style = TextStyle.Default.copy(
                    fontSize = 16.sp,
                    fontFamily = familyBioSans,
                    letterSpacing = 0.5.sp,
                )
            )
        }

        Box(
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth()
                .background(brush = Constants.gradientBrush, shape = RoundedCornerShape(3.dp))
                .padding(8.dp),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = "Event Details", color = Color.White, fontWeight = FontWeight.ExtraBold,
                style = TextStyle.Default.copy(
                    fontSize = 13.sp,
                    fontFamily = familyBioSans,
                    letterSpacing = 0.5.sp,
                )
            )
        }
    }
}
