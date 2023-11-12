package com.example.client.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.client.R
import com.example.client.ui.theme.SecondaryBg
import com.example.client.ui.theme.White

@Composable
fun Statistic(){
    Box(modifier = Modifier
        .padding(20.dp),
    ) {
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(15.dp, 15.dp, 15.dp, 15.dp))
                .background(SecondaryBg)
                .fillMaxWidth()
                .height(160.dp)
                .padding(30.dp, 20.dp, 30.dp, 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Box() {
                    StatisticItem(R.drawable.temp, "Temprature","26 C")
                }
                Box() {
                    StatisticItem(R.drawable.electric, "Energy Usage","256 k")
                }
            }
            Column(modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Box() {
                    StatisticItem(R.drawable.humidity, "Humidity","35%")
                }
                Box() {
                    StatisticItem(R.drawable.light, "Light intensity","50%")
                }
            }
        }
    }
}

@Composable
fun StatisticItem(link: Int, title: String, info: String){
    Row() {
        Icon(
            painter = painterResource(id = link),
            contentDescription = "Temp",
            modifier = Modifier
                .size(40.dp),
            tint = White,
        )
        Column(modifier = Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp)) {
            Text(text = info, color = White)
            Text(text = title, color = White)
        }
    }
}