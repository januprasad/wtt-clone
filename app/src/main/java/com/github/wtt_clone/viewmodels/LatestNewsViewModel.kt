package com.github.wtt_clone.viewmodels

import androidx.lifecycle.ViewModel
import com.github.wtt_clone.ChampionShipData
import com.github.wtt_clone.Constants.countryFlags
import com.github.wtt_clone.Constants.descriptions
import com.github.wtt_clone.Constants.images
import com.github.wtt_clone.Constants.players
import com.github.wtt_clone.Constants.titles
import com.github.wtt_clone.CurrentMatchData
import com.github.wtt_clone.LatestPageData
import com.github.wtt_clone.MatchPlayerData
import com.github.wtt_clone.ScoreCardData
import com.kevinnzou.compose.core.paginglist.easyPager
import com.kevinnzou.compose.core.paginglist.pagerconfig.PagingListWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject

@HiltViewModel
class LatestNewsViewModel @Inject constructor() : ViewModel() {
    val latestNewsPager = easyPager {
        loadPageData(it)
    }

    val scoreCardPager = easyPager {
        loadScoreCardData(it)
    }

    private suspend fun loadScoreCardData(page: Int): PagingListWrapper<ScoreCardData> {
        delay(1500)
        var data = mutableListOf<ScoreCardData>()
        repeat(3) {
            data.add(
                ScoreCardData(
                    match = ChampionShipData(
                        title = "WTT Contented Logos 2024",
                        countryFlag = countryFlags.random()
                    ),
                    currentMatch = CurrentMatchData(
                        day = "Today",
                        title = "Mixed Doubles - Quarter finale"
                    ),
                    matchPlayerData1 = MatchPlayerData(
                        flag = countryFlags.random(),
                        players = players.random().plus("/").plus(players.random()),
                        rank = "#${(1..8).random()}"
                    ),
                    matchPlayerData2 = MatchPlayerData(
                        flag = countryFlags.random(),
                        players = players.random().plus("/").plus(players.random()),
                        rank = "#${(1..8).random()}"
                    )
                )
            )
        }
        return PagingListWrapper(data, page < 3)
    }


    private suspend fun loadPageData(page: Int): PagingListWrapper<LatestPageData> {
        delay(1500)
        var data = mutableListOf<LatestPageData>()
        repeat(20) {
            data.add(
                LatestPageData(
                    image = images.random(),
                    title = titles.random(),
                    tag = "WTT Contented . ${(1..3).random()}hr ago",
                    description = descriptions.random()
                )
            )
        }
        return PagingListWrapper(data, page < 3)
    }

    fun randomNewsImage(): String = images.random()
    fun mapAllDescriptions(): String = descriptions.joinToString {
        it + "\n"
    }
}