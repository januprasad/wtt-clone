package com.github.wtt_clone.viewmodels

import androidx.lifecycle.ViewModel
import com.github.wtt_clone.Constants.images
import com.github.wtt_clone.VideoData
import com.kevinnzou.compose.core.paginglist.easyPager
import com.kevinnzou.compose.core.paginglist.pagerconfig.PagingListWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject

@HiltViewModel
class VideosViewModel @Inject constructor() : ViewModel() {
    val matchHighLightsPager = easyPager {
        loadPageData(it)
    }
    val compilationsPager = easyPager {
        loadPageData(it)
    }
    val behindTheScenesPager = easyPager {
        loadPageData(it)
    }
    val pressReleasePager = easyPager {
        loadPageData(it)
    }
    val playerReturnsPager = easyPager {
        loadPageData(it)
    }


    private suspend fun loadPageData(page: Int): PagingListWrapper<VideoData> {
        delay(500)
        val data = mutableListOf<VideoData>()
        repeat(5) {
            data.add(
                VideoData(
                    thumb = images.random(),
                    title = titles.random(),
                )
            )
        }
        return PagingListWrapper(data, page < 3)
    }


    val titles = listOf(
        "Lagos Main Draw Set as Top Seeds Chase Repeats and Redemption",
        "Confident and Prepared; Achanta Eyes Title As Lagos Campaign Kicks Off",
        "Champions Return; Lin And Chen Unveiled As Host Wildcards For Bangkok",
        "Pavade Powers Her Way to Top 20 Debut as Week 25 Rankings Drop",
        "Upset Denied As Groth Falls Agonisingly Short Against Top Seed Lebrun",
    )
}