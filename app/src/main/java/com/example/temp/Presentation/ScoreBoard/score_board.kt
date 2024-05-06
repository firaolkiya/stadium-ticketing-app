package com.example.temp.Presentation.ScoreBoard

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.temp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Board(){
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.onBackground,
                    titleContentColor = MaterialTheme.colorScheme.background,

                    ),
                title = { Text(text = "Score Board")},
                actions = {
                    Icon(imageVector = Icons.Default.Refresh,
                        contentDescription =null,
                        tint = LocalContentColor.current
                    )
                }
            )
        }
    )
    {pad->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(pad)
                .background(MaterialTheme.colorScheme.onBackground),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val cardColors = Brush.horizontalGradient(
                colors = listOf(Color.Green, Color.Blue)
            )
            LazyRow(
                reverseLayout = true,

            ) {
                items(6){i->
                    OutlinedButton(
                        modifier = Modifier
                            .padding(end = 20.dp)
                            .border(width = 2.dp, cardColors, RoundedCornerShape(25.dp)),
                        onClick = { /*TODO*/ }) {
                        Text(text = "Ethio League")
                    }
                }

            }
            Spacer(modifier = Modifier.height(15.dp))
            Row {
                val top:List<String> = listOf("5","10","15","20","25","30")
                var expanded = remember {
                    mutableStateOf(false)
                }
                var selected= remember {
                    mutableStateOf(top.first())
                }
                DropdownMenu(expanded = expanded.value,
                    onDismissRequest = { expanded.value=false }) {
                     top.forEach{t->
                         DropdownMenuItem(text = { Text(text = "${t}")},
                             onClick = { selected.value=t
                                 expanded.value=false
                             })
                     }
                }
                Text(text = "Top all", color = MaterialTheme.colorScheme.background)
                
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(start = 10.dp, end = 10.dp),
                colors = CardDefaults.cardColors(
                    containerColor =Color(15, 15, 15, 10),
                    contentColor = MaterialTheme.colorScheme.background
                ),

            ) {


                Row (
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween

                ){
                    Text(text = "  Team",modifier = Modifier
                        .padding(start=5.dp)
                        .weight(.31f))
                    Text(text = "LI",
                        modifier = Modifier
                            .weight(.18f))
                    Text(text = "W",
                        modifier = Modifier
                            .weight(.16f))
                    Text(text = "GD",
                        modifier = Modifier
                            .weight(.2f))
                    Text(text = "Pts",
                        modifier = Modifier
                            .weight(.15f))
                }

                @Composable
                fun getColor(i:Int):Color{
                    if (i%2==0) {
                        return MaterialTheme.colorScheme.inversePrimary
                    }
                    else{
                        return MaterialTheme.colorScheme.outlineVariant
                    }

                }
                LazyColumn {

                    items(20) { i ->
                       var color=getColor(i = i)
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(80.dp)
                                .padding(start = 10.dp, end = 10.dp, top = 5.dp)
                                .background(MaterialTheme.colorScheme.inverseSurface)
                                .border(
                                    .1.dp,
                                    MaterialTheme.colorScheme.inverseOnSurface,
                                ),
                            colors = CardDefaults.cardColors(
                                containerColor =MaterialTheme.colorScheme.inverseSurface
                            ),
                            shape = RectangleShape,
                            )
                        {

                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clickable { }
                                    .padding(start = 10.dp, end = 10.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically

                                ) {
                                Column(
                                    modifier = Modifier.weight(.3f),
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Image(
                                        modifier = Modifier
                                            ,
                                        painter = painterResource(id = R.drawable.flag),
                                        contentDescription = "flag",

                                    )
                                    Text(text = "${i + 1}.Arsenal ",
                                        modifier = Modifier
                                            .padding(top=2.dp)
                                            )

                                }
                                Text(text = "35",modifier = Modifier
                                    .weight(.2f))
                                Text(text = "12",modifier = Modifier
                                    .weight(.2f))
                                Text(text = "70",modifier = Modifier
                                    .weight(.2f))
                                Text(text = "65",modifier = Modifier
                                    .weight(.15f))
                            }
                        }
                    }
                }
            }



        }


        }


    }


@Preview
@Composable
fun View(){
    Board()
}