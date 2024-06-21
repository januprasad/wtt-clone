package com.github.wtt_clone

sealed class Screens(val route : String) {
    object Latest : Screens("latest_screen")
    object Events : Screens("events_screen")
    object Video : Screens("video_screen")
    object Players : Screens("players_screen")
    object Profile : Screens("profile_screen")
    object PlayerInfo : Screens("player_info_screen/{name}/{ranking}/{points}")
}