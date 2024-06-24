package com.example.kotlinappdemo.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.kotlinappdemo.models.ListData



@Composable
fun createListTemplate(listData: ListData) {

    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),

        modifier = Modifier
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp)

        ){
            Image(
                imageVector = Icons.Filled.Face,
                colorFilter = ColorFilter.tint(Color.White),
                alignment = Alignment.TopCenter,
                contentDescription = "Quote Item",
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.Black)

            )
            Spacer(modifier = Modifier.padding(4.dp))
            Column(
               modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = listData.prodName,
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .padding(0.dp,0.dp,0.dp,8.dp)
                )
                Box(
                    modifier = Modifier
                        .background(Color(0xFFEE0000))
                        .fillMaxWidth(.6f)
                        .height(1.dp)
                )
                Text(
                    text = listData.prodDetail,
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }


        }
    }

}
