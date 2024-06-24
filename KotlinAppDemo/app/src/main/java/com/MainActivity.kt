package com.example.kotlinappdemo

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.example.kotlinappdemo.screens.showListScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            DataManager.fetchJsonDataFromFile(applicationContext)
        }

        setContent {
           App()
        }
    }
}

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun App () {
    if(DataManager.isDataLoaded.value){
       //createListTemplate(listData = DataManager.data)
        showListScreen(listData = DataManager.data)
    }
}