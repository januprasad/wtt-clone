package com.github.wtt_clone

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem(
    val label : String = "",
    val icon : ImageVector = Icons.Filled.Home,
    val route : String = ""
) {
    fun bottomNavigationItems() : List<BottomNavigationItem> {
        return listOf(
            BottomNavigationItem(
                label = "Latest",
                icon = Icons.Filled.Home,
                route = Screens.Latest.route
            ),
            BottomNavigationItem(
                label = "Events",
                icon = Icons.Filled.Search,
                route = Screens.Events.route
            ),
            BottomNavigationItem(
                label = "Video",
                icon = Icons.Filled.AccountCircle,
                route = Screens.Video.route
            ),
            BottomNavigationItem(
                label = "Players",
                icon = Icons.Filled.AccountCircle,
                route = Screens.Players.route
            ),
            BottomNavigationItem(
                label = "Profile",
                icon = Icons.Filled.AccountCircle,
                route = Screens.Profile.route
            ),
        )
    }
}