package com.example.temp.Presentation.Component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.temp.R

@Composable
fun SportCardList(){

    LazyRow(
        modifier = Modifier
            .clickable {  }
    ) {
        items(7){i->
            val paddingStart = if (i==0) 15 else 0
            RecentCard(paddingStart = paddingStart)

        }

    }
}

@Composable
fun RecentCard(
    paddingStart:Int
){
    ElevatedCard(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onBackground
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 20.dp
        ),
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .size(200.dp)
            .padding(start = paddingStart.dp, end = 10.dp, top = 10.dp)
            .clipToBounds()

    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween

        ) {
            Text(
                text = "Arsenal vs Liver Pool",
                modifier = Modifier.padding(top = 3.dp),
                style = TextStyle(
                    color = MaterialTheme.colorScheme.onPrimary,
                )
            )

            Row {
                Image(
                    painter = painterResource(
                        id = R.drawable.ars_city
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .clickable {
                        },
                    contentScale = ContentScale.FillBounds,
                    contentDescription = null
                )
                Image(
                    painter = painterResource(
                        id = R.drawable.ars_city
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .clickable {
                        },
                    contentScale = ContentScale.FillBounds,
                    contentDescription = null
                )
            }

            Text(
                modifier = Modifier.padding(bottom = 5.dp),
                text = "Arsenal 2-1 m city",
                style = TextStyle(
                    fontSize = 15.sp,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            )
        }


    }
}