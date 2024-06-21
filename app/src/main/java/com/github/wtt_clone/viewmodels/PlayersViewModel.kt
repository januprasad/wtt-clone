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

}