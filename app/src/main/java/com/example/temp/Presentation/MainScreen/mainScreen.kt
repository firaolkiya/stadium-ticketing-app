import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.temp.domain.Model.Bars
import com.example.temp.Presentation.ScoreBoard.Board
import com.example.temp.Presentation.Dashboard.DashboardScreen
import com.example.temp.Presentation.Notification.NotificationScreen
import com.example.temp.Presentation.TicketPage.TicketPage

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("SuspiciousIndentation")
@Composable
fun MainScreen() {
    val navController: NavController = rememberNavController()
    val barItem = listOf(
        Bars(
            title = "Home",
            icon = Icons.Default.Home,
            route = "home_screen"
        ),
        Bars(
            title = "setting",
            icon = Icons.Default.ShoppingCart,
            route = "setting_screen"
        ),
        Bars(
            title = "notification",
            icon = Icons.Default.Notifications,
            route = "notification_screen"
        )
    )
    Column(
        modifier = Modifier
            .background(Color.Green)
            .fillMaxSize()
    ) {
        Scaffold(
            bottomBar = {

                NavigationBar(
                    containerColor = MaterialTheme.colorScheme.outlineVariant,
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.primary)
                        .height(50.dp),
                ) {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination
                    barItem.forEachIndexed { _, item ->
                        NavigationBarItem(
                            modifier = Modifier.wrapContentSize(),
                            selected = currentDestination?.hierarchy?.any { it.route == item.route } == true,
                            icon = {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = item.title
                                )
                            },
                            onClick = {
                                navController.navigate(item.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    // Avoid multiple copies of the same destination when
                                    // reselecting the same item
                                    launchSingleTop = true
                                    // Restore state when reselecting a previously selected item
                                    restoreState = true

                                }
                            },
                        )

                    }
                }

            }
        ) { innerPadding ->
            NavHost(
                navController = navController as NavHostController,
                startDestination = "home_screen",
                Modifier.padding(innerPadding)
            ) {

                composable("home_screen") {
                    DashboardScreen()
                }
                composable("setting_screen") {
                    Board()
                }
                composable("ticket_page") {
                    TicketPage(navController)
                }
                composable("notification_screen") {
                    NotificationScreen(navController)
                }
//                    composable("deep_view") {
//                        MoreView(image = R.drawable.ars_city)
//                    }

            }
        }


    }
}



@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun ShowView(){
    MainScreen()
}




