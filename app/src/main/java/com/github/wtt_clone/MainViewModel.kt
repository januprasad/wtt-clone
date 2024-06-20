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
        loadData(it)
    }
    private suspend fun loadData(page: Int): PagingListWrapper<String> {
        delay(1500)
        val data = mutableListOf("Page ${page+1}")
        repeat(10) {
            data.add("Item ${it+1+((page)*10)}")
        }
        return PagingListWrapper(data, page < 3)
    }
}