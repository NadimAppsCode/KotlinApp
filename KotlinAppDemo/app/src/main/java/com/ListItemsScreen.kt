package com.example.kotlinappdemo.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.kotlinappdemo.models.ListData


@Composable
fun showListScreen(listData: Array<ListData>) {
    Column {
        Text(
            text = "Json Data List",
            textAlign = TextAlign.Center,
            color = Color.Red
        )
        lazyLoadingData(data = listData)
    }
    
}