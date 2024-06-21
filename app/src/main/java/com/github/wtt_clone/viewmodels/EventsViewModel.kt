package com.github.wtt_clone.viewmodels

import androidx.lifecycle.ViewModel
import com.github.wtt_clone.EventData
import com.kevinnzou.compose.core.paginglist.easyPager
import com.kevinnzou.compose.core.paginglist.pagerconfig.PagingListWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject

@HiltViewModel
class EventsViewModel @Inject constructor() : ViewModel() {
    val eventsPager = easyPager {
        loadEventsData(it)
    }


    private suspend fun loadEventsData(page: Int): PagingListWrapper<EventData> {
        delay(1500)
        var data = mutableListOf<EventData>()
        repeat(20) {
            data.add(
                EventData(
                    countryFlag = countryFlags.random(),
                    title = titles.random(),
                    description = descriptions.random(),
                    date = "${(1..30).random()} - June 2024",
                )
            )
        }
        return PagingListWrapper(data, page < 3)
    }

    private val countryFlags = listOf(
        "https://documentstore.ittf.com/websitefiles/assets/flags_normal/in.png",
        "https://documentstore.ittf.com/websitefiles/assets/flags_normal/us.png",
        "https://documentstore.ittf.com/websitefiles/assets/flags_normal/mn.png",
        "https://documentstore.ittf.com/websitefiles/assets/flags_normal/kn.png",
        "https://documentstore.ittf.com/websitefiles/assets/flags_normal/ws.png",
    )
    val titles = listOf(
        "WTT Contender Lagos 2024",
        "WTT Youth Star Contender Lima 2024",
        "WTT Contender Tunis 2024 Presented by KIA",
        "WTT Youth Contender Westchester 2024",
        "WTT Youth Contender Benghazi 2024",
    )
    val descriptions = listOf(
        "Benghazi Sport Complex Benghazi, Libya",
        "Westchester Table Tennis Center Pleasantville, USA",
        "Salle Omnisport de Rades Tunis, Tunisia",
        "Villa Deportiva Nacional (VIDENA) Lima, Peru",
    )
}