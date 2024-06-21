package com.github.wtt_clone

data class LatestPageData(
    val image: String,
    val title: String,
    val tag: String,
    val description: String,
)
data class ScoreCardData(
    val match: ChampionShipData,
    val currentMatch: CurrentMatchData,
    val matchPlayerData1: MatchPlayerData,
    val matchPlayerData2: MatchPlayerData,
)
data class ChampionShipData(
    val title: String,
    val countryFlag: String,
)
data class CurrentMatchData(
    val day: String,
    val title: String,
)
data class MatchPlayerData(
    val flag: String,
    val players: String,
    val rank: String,
)

data class EventData(
    val date: String,
    val title: String,
    val countryFlag: String,
    val description: String,
)
data class VideoData(
    val thumb: String,
    val title: String,
)
data class PlayerData(
    val profileImage: String,
    val name: String,
    val country: String,
    val ranking: String,
    val countryFlag: String,
    val points: String,
    val lastMatch: String
)
