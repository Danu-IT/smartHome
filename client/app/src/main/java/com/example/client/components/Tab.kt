package com.example.client.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.client.ui.theme.Gray
import com.example.client.ui.theme.MainBg
import com.example.client.ui.theme.White
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabLayout(){
    val tablist = listOf("LIGHT", "HUMIDIFIER", "HEATING", "TEMP")
    val pagerState = rememberPagerState()
    val tabIndex = pagerState.currentPage
    val coroutineScope = rememberCoroutineScope()

    Column(modifier = Modifier.padding(top = 20.dp)) {
        TabRow(
            contentColor = MainBg,
            selectedTabIndex = tabIndex,
            divider = { TabRowDefaults.contentColor},
            indicator = {list ->
                TabRowDefaults.Indicator(
                    Modifier.tabIndicatorOffset(list[tabIndex]).background(MainBg)
                )
            },
            tabs = {
                tablist.forEachIndexed{index, text ->
                    Tab(
                        selected = index == tabIndex,
                        onClick = {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(index)
                            }
                        },
                        text = {
                            Text(text = text, fontSize = 12.sp,)
                        },
                        modifier = Modifier
                            .width(100.dp)
                            .background(MainBg),
                        selectedContentColor = White,
                        unselectedContentColor = Gray,
                    )
                }
            }
        )
        HorizontalPager(
            count = tablist.size,
            state = pagerState,
            modifier = Modifier.weight(1.0f)
        ) {index ->
            when (tabIndex) {
                0 -> Light()
                1 -> Humidifier()
                2 -> Heating()
                3 -> Temperature()
            }
        }
    }
}

@Composable
fun Light(){
    Column(
        modifier = Modifier.fillMaxHeight(),
    ) {
        Statistic()
        Row(modifier = Modifier.padding(20.dp, 0.dp).fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                Switcher()
                Switcher()
            }
            Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                Switcher()
                Switcher()
            }
        }
    }
}
@Composable
fun Humidifier(){
    Box(modifier = Modifier.fillMaxSize()){
        Row() {
            Text(text = "Humidifier - Влажность")
        }
    }
}
@Composable
fun Heating(){
    Box(modifier = Modifier.fillMaxSize()){
        Row() {
            Text(text = "Humidifier - Отопление")
        }
    }
}
@Composable
fun Temperature(){
    Box(modifier = Modifier.fillMaxSize()){
        Row() {
            Text(text = "Temperature - Температура")
        }
    }
}