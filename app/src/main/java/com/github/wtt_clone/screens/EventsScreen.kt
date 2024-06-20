package com.github.wtt_clone.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.github.wtt_clone.EventData
import com.github.wtt_clone.R

@Composable
fun EventsScreen(navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp),
        ) {
            val eventData = EventData(
                date = "19 - June 2024",
                title = "Contrary to popular belief, Lorem Ipsum",
                countryFlag = "https://picsum.photos/200/300?random",
                description = "There are many variations of passages of Lorem Ipsum"
            )
            repeat(3) {
                EventCards(eventData)
            }

        }
    }
}

@Composable
fun EventCards(eventData: EventData) {
    Column {
        Text(
            text = eventData.date, style = TextStyle.Default.copy(
                fontSize = 18.sp,
            )
        )
        Text(
            text = eventData.title, style = TextStyle.Default.copy(
                fontSize = 24.sp,
            )
        )

        Row {
            ImageLoaderWTT(eventData.countryFlag, modifier = Modifier.height(60.dp).width(100.dp))
            Text(
                text = eventData.description, style = TextStyle.Default.copy(
                    fontSize = 16.sp,
                )
            )
        }
    }
}
