package com.example.client.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.client.components.Header
import com.example.client.components.TabLayout
import com.example.client.ui.theme.MainBg

@Composable
fun Main() {
    Box(modifier = Modifier
        .background(MainBg)
        .padding(top = 22.dp)
        .fillMaxSize(),
    )
    {
        Column {
            Header()
            TabLayout()
        }
    }
}
