package com.example.temp.Presentation.Component

import androidx.compose.foundation.Image
import com.example.temp.R
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.temp.domain.Model.Game

fun LazyListScope.UpcomingCardList(
    onEmptyText:String,
    listOfEvent:List<Game>,
    onGameEventClicked:()->Unit
) {
    item{
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Upcoming Events", style = TextStyle(
                    color = MaterialTheme.colorScheme.background,
                    fontSize = 20.sp,
                    fontWeight = FontWeight(300)
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            if (listOfEvent.isEmpty()){
                    Image(
                        contentScale = ContentScale.Fit,
                        painter = painterResource(id = R.drawable.event),
                        contentDescription ="No Event"
                    )
                    Text(text = onEmptyText,
                        style =MaterialTheme.typography.bodyMedium.copy(MaterialTheme.colorScheme.background))
                    

            }
            else{
                Row(
                    modifier= Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp, top = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Text(text = "Team",
                        style = MaterialTheme.typography.labelSmall.copy(color = MaterialTheme.colorScheme.background),
                        modifier = Modifier
                            .padding(start = 15.dp)
                            .weight(.5f),)
                    Text(text = "Date",
                        style = MaterialTheme.typography.labelSmall.copy(color = MaterialTheme.colorScheme.background),
                        modifier = Modifier.weight(.3f))
                    Text(text = "Ticket",
                        style = MaterialTheme.typography.labelSmall.copy(color = MaterialTheme.colorScheme.background),
                        modifier = Modifier.weight(.2f))
                }
                Spacer(modifier = Modifier.height(10.dp))
            }
            }
        }

    
    items(listOfEvent) { game ->
        UpcomingCard(
            event = game,
            onGameEventClicked = onGameEventClicked
        )
    }

}

@Composable
fun UpcomingCard(
    event:Game,
    onGameEventClicked:()->Unit
){
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.inverseSurface

        ),
        shape = RectangleShape,
        modifier = Modifier
            .height(80.dp)
            .padding(start = 15.dp, end = 10.dp, top = 5.dp)
            .border(1.dp, Color.LightGray)
            .background(Color(60, 56, 56, 10)),

        ) {
        Row(
            modifier = Modifier
                .padding(start = 5.dp, end = 5.dp)
                .fillMaxSize()
                .clickable {
                    onGameEventClicked()
                },
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                modifier = Modifier.weight(.1f),
                imageVector = Icons.Filled.Star,
                contentDescription = null
            )

            Text(
                text = "${event.club1} vs ${event.club2}",
                modifier = Modifier.weight(.35f),
            )
            Text(
                text = event.gameDate,
                modifier = Modifier.weight(.25f),
            )
            Text(
                text = "${event.remainTicket}",
                modifier = Modifier.weight(.15f),
            )
        }
    }
}
