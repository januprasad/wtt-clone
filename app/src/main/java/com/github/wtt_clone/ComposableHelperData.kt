package com.github.wtt_clone

data class LatestPageData(
    val image: String,
    val title: String,
    val tag: String,
    val description: String,
)

data class EventData(
    val date: String,
    val title: String,
    val countryFlag: String,
    val description: String,
)
