package com.github.wtt_clone.viewmodels

import androidx.lifecycle.ViewModel
import com.github.wtt_clone.ChampionShipData
import com.github.wtt_clone.CurrentMatchData
import com.github.wtt_clone.LatestPageData
import com.github.wtt_clone.PlayersData
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
        repeat(20) {
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
                    playersData1 = PlayersData(
                        flag = countryFlags.random(),
                        players = players.random().plus("/").plus(players.random()),
                        rank = "#${(1..8).random()}"
                    ),
                    playersData2 = PlayersData(
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

    private val countryFlags = listOf(
        "https://documentstore.ittf.com/websitefiles/assets/flags_normal/in.png",
        "https://documentstore.ittf.com/websitefiles/assets/flags_normal/us.png",
        "https://documentstore.ittf.com/websitefiles/assets/flags_normal/mn.png",
        "https://documentstore.ittf.com/websitefiles/assets/flags_normal/kn.png",
        "https://documentstore.ittf.com/websitefiles/assets/flags_normal/ws.png",
    )
    private val images = listOf(
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
    val descriptions = listOf(
        "WTT Star Contender Ljubljana 2024 Presented by I Feel Slovenia continues to bring the heat with another incredible day of Men’s Singles action. This time it was Jonathan Groth’s turn to ramp up the atmosphere inside Hala Tivoli, falling just shy of a dramatic quarterfinal upset against No.1 seed Felix Lebrun (11-9, 5-11, 10-12, 11-6, 11-6).",
        "Seeded at No.12 for the week, Groth exceeded ranking expectations with his run to the last eight. Showcasing nerves of steel to overturn a 0-2 deficit to beat Hiroto Shinozuka on Day 2, Groth was equally as magnificent on Day 3, speeding past Andrej Gacina 3-0 (11-9, 16-14, 11-9) to reach his first WTT Star Contender quarterfinal.",
        "Prithika Pavade’s magical run at WTT Star Contender Ljubljana 2024 Presented by I Feel Slovenia continues to capture the imagination of the fans in attendance at Hala Tivoli, producing another stunning effort on Saturday to turn heads in the Slovenian capital.",
        "Needing just one more game to claim a huge scalp, Groth had the finish line in sight as Ljubljana held its breath. But Lebrun would crack the code late on, rising to the challenge in game four to level the scores, and he wouldn’t let it slip from there, finding enough in his back pocket to go again in the fifth to deny the upset.",
        "Facing off against No.4 seed Mima Ito for the second time in eight days, Pavade was going for an unlikely double over the Japanese star on Saturday, and she remarkably pulled off the feat, taking huge belief from her win over Ito at last week’s WTT Contender Zagreb to earn another shock win over the former World No.2 (5-11, 11-4, 11-8, 11-6).",
    )
    val players = listOf(
        "Thakkar",
        "Kamath",
        "Kuti",
        "Bello",
        "Diaz",
        "Florex",
        "Sardar",
        "Mathan"
    )
}