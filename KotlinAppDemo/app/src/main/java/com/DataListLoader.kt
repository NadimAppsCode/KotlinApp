package com.example.kotlinappdemo.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.kotlinappdemo.models.ListData

@Composable
fun lazyLoadingData(data : Array<ListData>) {
    LazyColumn(content = {
        items(data) {
            createListTemplate(it)
        }
    })
}