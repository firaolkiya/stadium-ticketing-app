package com.example.temp

import MainScreen
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.temp.Presentation.Dashboard.DashboardScreen
import com.example.temp.domain.Model.Game
import com.example.temp.ui.theme.TempTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TempTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.onBackground
                ) {
                    MainScreen()
                }
            }
        }
    }





    @RequiresApi(Build.VERSION_CODES.O)
    @Preview
    @Composable
    fun view(){
        DashboardScreen()
    }
}
val UpcomingList:List<Game> = listOf(
    Game(club1="Arsenal",
        club2 = "City",
        remainTicket = 20,
        gameDate = "2/3/3024",
        gameId = 1,
        gamePlace = "Adama"
    ),
    Game(club1="Liverpool",
        club2 = "Manchester",
        remainTicket = 10,
        gameDate = "2/3/3024",
        gameId = 1,
        gamePlace = "Adama"
    ),
    Game(club1="Arsenal",
        club2 = "City",
        remainTicket = 20,
        gameDate = "2/3/3024",
        gameId = 1,
        gamePlace = "Adama"
    ),
    Game(club1="Arsenal",
        club2 = "City",
        remainTicket = 20,
        gameDate = "2/3/3024",
        gameId = 1,
        gamePlace = "Adama"
    ),
    Game(club1="Arsenal",
        club2 = "City",
        remainTicket = 20,
        gameDate = "2/3/3024",
        gameId = 1,
        gamePlace = "Adama"
    )
)

