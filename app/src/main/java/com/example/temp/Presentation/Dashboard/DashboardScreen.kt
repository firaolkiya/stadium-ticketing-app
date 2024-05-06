package com.example.temp.Presentation.Dashboard

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.temp.Presentation.Component.SportCardList
import com.example.temp.Presentation.Component.UpcomingCardList
import com.example.temp.UpcomingList

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DashboardScreen() {
    Scaffold(
        topBar = {
            DashboardTopAppBar()
        },


        ) { innerPadding ->
        LazyColumn (
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.onBackground),
            horizontalAlignment = Alignment.CenterHorizontally

        ){
            item{
                Spacer(modifier = Modifier.height(7.dp))
                Text(
                    text = "Past Events",
                    style = TextStyle(
                        fontSize = 18.sp,
                        color = MaterialTheme.colorScheme.background
                    )
                )
            }
            item {
                SportCardList()
            }

            item {
                Spacer(modifier = Modifier.height(10.dp))
            }

                UpcomingCardList(
                    onEmptyText = "No Upcoming Event to Show\n Check notification",
                    listOfEvent = UpcomingList,
                    onGameEventClicked = {}
                )




        }
    }
}

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun DashboardTopAppBar() {

        CenterAlignedTopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.onBackground,
                titleContentColor = MaterialTheme.colorScheme.background,

                ),
            title = {
                Text(
                    "Sport App",
                    style = TextStyle(
                        color = MaterialTheme.colorScheme.background,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Medium
                    )
                )

            },
            navigationIcon = {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
            },

        )
    }

@RequiresApi(Build.VERSION_CODES.O)
@Composable
@Preview
fun Show(){
    DashboardScreen()
}


