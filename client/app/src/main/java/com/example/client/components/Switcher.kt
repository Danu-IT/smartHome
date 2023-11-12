package com.example.client.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.client.R
import com.example.client.ui.theme.Active
import com.example.client.ui.theme.DarkActive
import com.example.client.ui.theme.Gray
import com.example.client.ui.theme.MainBg
import com.example.client.ui.theme.SecondaryBg
import com.example.client.ui.theme.White

@Composable
fun Switcher(){
    val state = remember {
        mutableStateOf(false)
    }
    Column(modifier = Modifier
        .clip(RoundedCornerShape(15.dp, 15.dp, 15.dp, 15.dp))
        .background(ColorBg(state.value))
        .height(130.dp)
        .width(175.dp)
        .padding(start = 15.dp, end = 25.dp)
    ){
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                painter = painterResource(id = R.drawable.light),
                contentDescription = "Menu",
                modifier = Modifier
                    .size(50.dp),
                tint = ColorIcon(state.value)
            )
            Switch(checked = state.value, onCheckedChange = {
                state.value = !state.value
            } ,
                modifier = Modifier
                    .scale(1.2f)
                    .padding(top = 10.dp),
                colors = SwitchDefaults.colors(
                checkedThumbColor = Active,
                checkedTrackColor = SecondaryBg,
                checkedBorderColor = Active,
                uncheckedThumbColor = SecondaryBg,
                uncheckedTrackColor = DarkActive,
                uncheckedBorderColor = MainBg,
                disabledCheckedThumbColor = Color.Green.copy(alpha = ContentAlpha.disabled),
                disabledCheckedTrackColor = Color.LightGray.copy(alpha = ContentAlpha.disabled),
                disabledCheckedBorderColor = Color.Green.copy(alpha = ContentAlpha.disabled),
                disabledUncheckedThumbColor = Color.Red.copy(alpha = ContentAlpha.disabled),
                disabledUncheckedTrackColor = Color.LightGray.copy(alpha = ContentAlpha.disabled),
                disabledUncheckedBorderColor = Color.Red.copy(alpha = ContentAlpha.disabled),
            ))
        }
        Column(modifier = Modifier.padding(top = 5.dp)) {
            Text(text = "Light", color = White, fontSize = 16.sp)
            Text(text = "Phillips hue", color = Gray, fontSize = 12.sp)
        }
    }
}

fun ColorIcon(checked: Boolean): Color{
    if(checked) return Active
    return White
}

fun ColorBg(checked: Boolean): Color{
    if(checked) return DarkActive
    return SecondaryBg
}