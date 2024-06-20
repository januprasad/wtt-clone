package com.github.wtt_clone

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource

data class BottomNavigationItem(
    val label : String = "",
    val icon : Int=0,
    val route : String = ""
) {
    fun bottomNavigationItems() : List<BottomNavigationItem> {
        return listOf(
            BottomNavigationItem(
                label = "Latest",
                icon = R.drawable.latest,
                route = Screens.Latest.route
            ),
            BottomNavigationItem(
                label = "Events",
                icon = R.drawable.events,
                route = Screens.Events.route
            ),
            BottomNavigationItem(
                label = "Video",
                icon = R.drawable.video,
                route = Screens.Video.route
            ),
            BottomNavigationItem(
                label = "Players",
                icon = R.drawable.players,
                route = Screens.Players.route
            ),
            BottomNavigationItem(
                label = "Profile",
                icon = R.drawable.profile,
                route = Screens.Profile.route
            ),
        )
    }
}