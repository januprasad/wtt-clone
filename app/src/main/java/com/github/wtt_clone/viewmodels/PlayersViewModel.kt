package com.github.wtt_clone.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.github.wtt_clone.PlayerData
import com.kevinnzou.compose.core.paginglist.easyPager
import com.kevinnzou.compose.core.paginglist.pagerconfig.PagingListWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject

@HiltViewModel
class PlayersViewModel @Inject constructor() : ViewModel() {
    val playersPager = easyPager {
        loadPlayersData(it)
    }
    val playersPager2 = easyPager {
        loadPlayersData1(it)
    }

    private suspend fun loadPlayersData(page: Int): PagingListWrapper<PlayerData> {
        delay(1500)
//        var data = mutableListOf<PlayerData>()
        val data = names.mapIndexed { index, name ->
            PlayerData(
                profileImage = profileImages.random(),
                name = name,
                country = country.random(),
                ranking = "${index + 1}",
                countryFlag = countryFlags.random(),
                points = "${(3000..8000).random()}",
                lastMatch = "Blah blah"
            )
        }
        return PagingListWrapper(data, false)
    }

    private suspend fun loadPlayersData1(page: Int): PagingListWrapper<PlayerData> {
        delay(1500)
        var data = mutableListOf<PlayerData>()
        repeat(20) {
            data.add(
                PlayerData(
                    profileImage = profileImages.random(),
                    name = names[it % 2],
                    country = country.random(),
                    ranking = "${it + 6}",
                    countryFlag = countryFlags.random(),
                    points = "${(3000..8000).random()}",
                    lastMatch = "Blah blah"
                )
            )
        }
        return PagingListWrapper(data, page > 3)
    }

    private val countryFlags = listOf(
        "https://documentstore.ittf.com/websitefiles/assets/flags_normal/in.png",
        "https://documentstore.ittf.com/websitefiles/assets/flags_normal/us.png",
        "https://documentstore.ittf.com/websitefiles/assets/flags_normal/mn.png",
        "https://documentstore.ittf.com/websitefiles/assets/flags_normal/kn.png",
        "https://documentstore.ittf.com/websitefiles/assets/flags_normal/ws.png",
    )

    private val profileImages = listOf(
        "https://wttsimfiles.blob.core.windows.net/wtt-media/photos/400px/119588_Headshot_R_LIANG_Jingkun.png",
        "https://wttsimfiles.blob.core.windows.net/wtt-media/photos/400px/135977_HEADSHOT_R_Felix_LEBRUN.png",
        "https://wttsimfiles.blob.core.windows.net/wtt-media/photos/400px/105649_Headshot_R_MA_Long.png",
        "https://wttsimfiles.blob.core.windows.net/wtt-media/photos/400px/121404_Headshot_R_FAN_Zhendong.png",
        "https://wttsimfiles.blob.core.windows.net/wtt-media/photos/400px/121558_Headshot_R_WANG_Chuqin.png",
    )

    fun generateRandomProfilePicture() = profileImages.random()
    fun generateRandomFlag() = countryFlags.random()
    fun generateRandomDescription() = descriptions.random()
    val names = listOf(
        "WANG Chuqin",
        "FAN Zhendong",
        "LIANG Jingkun",
        "MA Long",
        "Felix LEBRUN",
    )
    val country = listOf(
        "CHN",
        "FRA",
        "KOR",
        "SWE"
    )
    val descriptions = listOf(
        "WTT Star Contender Ljubljana 2024 Presented by I Feel Slovenia continues to bring the heat with another incredible day of Men’s Singles action. This time it was Jonathan Groth’s turn to ramp up the atmosphere inside Hala Tivoli, falling just shy of a dramatic quarterfinal upset against No.1 seed Felix Lebrun (11-9, 5-11, 10-12, 11-6, 11-6).",
        "Seeded at No.12 for the week, Groth exceeded ranking expectations with his run to the last eight. Showcasing nerves of steel to overturn a 0-2 deficit to beat Hiroto Shinozuka on Day 2, Groth was equally as magnificent on Day 3, speeding past Andrej Gacina 3-0 (11-9, 16-14, 11-9) to reach his first WTT Star Contender quarterfinal.",
        "Prithika Pavade’s magical run at WTT Star Contender Ljubljana 2024 Presented by I Feel Slovenia continues to capture the imagination of the fans in attendance at Hala Tivoli, producing another stunning effort on Saturday to turn heads in the Slovenian capital.",
        "Needing just one more game to claim a huge scalp, Groth had the finish line in sight as Ljubljana held its breath. But Lebrun would crack the code late on, rising to the challenge in game four to level the scores, and he wouldn’t let it slip from there, finding enough in his back pocket to go again in the fifth to deny the upset.",
        "Facing off against No.4 seed Mima Ito for the second time in eight days, Pavade was going for an unlikely double over the Japanese star on Saturday, and she remarkably pulled off the feat, taking huge belief from her win over Ito at last week’s WTT Contender Zagreb to earn another shock win over the former World No.2 (5-11, 11-4, 11-8, 11-6).",
    )

}