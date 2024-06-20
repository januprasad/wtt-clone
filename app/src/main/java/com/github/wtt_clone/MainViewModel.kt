package com.github.wtt_clone

import androidx.lifecycle.ViewModel
import com.kevinnzou.compose.core.paginglist.easyPager
import com.kevinnzou.compose.core.paginglist.pagerconfig.PagingListWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    val pager = easyPager {
        loadPageData(it)
    }


    private suspend fun loadPageData(page: Int): PagingListWrapper<LatestPageData> {
        delay(1500)
        var data = mutableListOf<LatestPageData>()
        repeat(20) {
            data.add(
                LatestPageData(
                    image = "https://picsum.photos/200/300?random=$it",
                    title = "Contrary to popular belief, Lorem Ipsum is not simply random text.",
                    tag = "Tag $it",
                    description = "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable."
                )
            )
        }
        return PagingListWrapper(data, page < 3)
    }
}