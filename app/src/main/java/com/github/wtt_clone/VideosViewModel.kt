package com.github.wtt_clone

import androidx.lifecycle.ViewModel
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

    val images = listOf(
        "https://pixabay.com/get/ge2c2b28b221d334b28f4187827f3d81ae73f56b540649c662b2357de621af0ad3b044c4daf93f808913ddbc301f6fb69f8369527425535b4a3d247d42f28e3b3_640.jpg",
        "https://pixabay.com/get/g2192d35c3aaf210661ea14a46b9ec48a9b31a11838c001e253cf0a888b181c06864b8dc25fac4eb534d3147fac7bb52ca0fa009d231ca2964a1bce3b0cab00fe_640.jpg",
        "https://pixabay.com/get/g151a22ef3427d8dd8060c8b2a69216b8f11e3656b4c6e7a6b955a4a33fa23d761272b74cf062050b63a51c528c0b81c8926caf75355683f30088610266a480dd_640.jpg",
        "https://pixabay.com/get/g42c10382dd914316d9450b75869f920495f78cda82243d4de119aa602674057e857760e08893cb6b7c0f974b4bd395bca45878dcc3a191b76e3f89fb26903241_640.jpg",
        "https://pixabay.com/get/g10def899c9054f06d33cb8e8322afcb9ade2c70d3c7a3f2d07f1d633e9ea6e17e93093663cd7d826bf449239e96e4445c485ce758c9d8caf2a5e819b29fe8f74_640.jpg",
        "https://pixabay.com/get/ga3b0814959aae70bebd274888ed7cb9bf3e40e40aefad829503bb48a4b3d2a5a58522afcd665a886a6adbc41ed04b92abdc032631c36de3716f53d3891b497b5_640.jpg",
        "https://wttwebcmsprod.blob.core.windows.net/articledetailimages/Sharath-Kamal-ACHANTA-(IND)_Contender_2024_Lagos_Day-2_1-(10)_a59f6233-5342-4d0a-8505-d407f6570f07.png",
    )
    val titles = listOf(
        "Lagos Main Draw Set as Top Seeds Chase Repeats and Redemption",
        "Confident and Prepared; Achanta Eyes Title As Lagos Campaign Kicks Off",
        "Champions Return; Lin And Chen Unveiled As Host Wildcards For Bangkok",
        "Pavade Powers Her Way to Top 20 Debut as Week 25 Rankings Drop",
        "Upset Denied As Groth Falls Agonisingly Short Against Top Seed Lebrun",
    )
}