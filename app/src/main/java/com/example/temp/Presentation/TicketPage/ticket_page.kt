package com.example.temp.Presentation.TicketPage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.temp.R

@Composable
fun TicketPage(navController:NavController){
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.onBackground)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
    Row (
        modifier = Modifier
            .padding(top = 8.dp, start = 10.dp, end = 50.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .clickable {
                    navController.navigate("home_screen") {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true

                    }
                },

            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                tint = MaterialTheme.colorScheme.background,
                contentDescription = "back"
            )
        }
        Text(
            text = "Arsenal vs City",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.background
        )
    }
        Box (
            modifier= Modifier.padding(10.dp)
        ){
            Image(modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
                contentScale = ContentScale.FillBounds,
                painter = painterResource(id = R.drawable.stadium2),
                contentDescription ="stadium" )

        }
        Text(
            text = "Adama Stadium",
            style = TextStyle(
                color = MaterialTheme.colorScheme.background,
                fontSize = 18.sp,
                fontWeight = FontWeight(600)
                )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Location: Adama, Eastern Showa\n" +
                    ",Oromia,Ethiopia\nZIP: 4648578\n Sub City: Bole",

            style = TextStyle(
                color = MaterialTheme.colorScheme.background,
                fontSize = 16.sp,
                fontWeight = FontWeight(400)
            )
        )
        Button(
            shape = RectangleShape,
            onClick = { /*TODO*/ }) {
            Text(text = "See on Map")
            
        }

        Card (
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(top = 10.dp, start = 10.dp, end = 10.dp, bottom = 25.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.inverseSurface
            )
        ){
            Column (
                modifier = Modifier
                    .padding(start = 7.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ){
                Row (
                    modifier = Modifier
                        .padding(7.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ){

                    Text(
                        "Time Left:    ",
                        style = TextStyle(
                            fontSize = 20.sp,
                            color = MaterialTheme.colorScheme.inverseOnSurface

                        )
                    )
                    Text(
                        text="01:23:09:11",
                        style = TextStyle(
                            fontSize = 35.sp,
                            color = MaterialTheme.colorScheme.inverseOnSurface

                        )
                    )

                }
                Text(
                    text="Available Tickets:  23",
                    style = TextStyle(
                        fontSize = 23.sp,
                        color = MaterialTheme.colorScheme.inverseOnSurface

                    )
                )
                Box(modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                    ) {
                    Button(
                        modifier = Modifier
                            .width(200.dp),
                        shape = RectangleShape,
                        onClick = {
                            navController.navigate("payment_Page") {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                // Avoid multiple copies of the same destination when
                                // reselecting the same item
                                launchSingleTop = true
                                // Restore state when reselecting a previously selected item
                                restoreState = true

                            }
                        }) {
                        Text(text = "Buy Now")
                    }
                }
            }

        }





    }
}
/*
@Preview(showBackground = true)
@Composable
fun ViewPage(){
    TicketPage()
}
*/
