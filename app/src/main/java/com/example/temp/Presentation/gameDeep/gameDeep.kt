package com.example.temp.Presentation.gameDeep

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.temp.R

@SuppressLint("MutableCollectionMutableState")
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MoreView(image:Int){
    val numLike=0
    val numComment=0
    Column (
    modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.onBackground),
        horizontalAlignment = Alignment.CenterHorizontally,

    ){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 6.dp)
                .height(50.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Box(modifier = Modifier
                .clickable { }
                .padding(top = 5.dp)
                .size(40.dp, 40.dp)
                .background(MaterialTheme.colorScheme.onSecondaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    tint = MaterialTheme.colorScheme.background,
                    contentDescription = null
                )
            }

            Text(text = "OverView",
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.background
            )
            Box(modifier = Modifier
                .clickable { }
                .padding(top = 5.dp)
                .size(40.dp, 40.dp)
                .background(MaterialTheme.colorScheme.onSecondaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Filled.Refresh,
                    tint = MaterialTheme.colorScheme.background,
                    contentDescription = null
                )
            }

        }

        Card (
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(start = 10.dp, end = 10.dp, top = 5.dp)
                .border(1.dp, MaterialTheme.colorScheme.onBackground, RoundedCornerShape(0.dp))
                .clip(RoundedCornerShape(4.dp)),

            shape = RectangleShape
        ){
            Image(
                modifier = Modifier
                    .border(0.dp, MaterialTheme.colorScheme.background, RectangleShape)
                    .fillMaxSize()
                ,
                painter = painterResource(id = image),
                contentScale = ContentScale.FillBounds,
                contentDescription =null )

        }
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 10.dp, end = 10.dp)
                .background(MaterialTheme.colorScheme.inverseSurface),
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            Column {
                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Arsenal 2 - 0 City",
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.background
                    )


                )
                Text(
                    modifier = Modifier
                        .padding(start=15.dp),
                    text = "Saaka  51'\n" +
                            " Martineli 67'\n" +
                            " Oland 72'",
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.background
                    )
                )
            }
            Row(
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp, top = 10.dp, bottom = 5.dp)
                    .border(1.dp, MaterialTheme.colorScheme.onBackground)
                    .width(300.dp)
                    .clip(RoundedCornerShape(5.dp)),

                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .width(100.dp),
                    onClick = { /*TODO*/ }) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.comment),
                            contentDescription = null,
                            modifier= Modifier
                                .clickable {  }
                        )
                        Text(
                            text = numComment.toString(),
                            modifier =Modifier
                                .padding(start=2.dp),
                            style = TextStyle(
                                fontWeight = FontWeight.ExtraBold,
                                color = MaterialTheme.colorScheme.background,
                                fontSize = 20.sp
                            )
                        )
                    }
                }
                IconButton(
                    modifier = Modifier
                        .width(100.dp),
                    onClick = { /*TODO*/ }) {
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.like),
                            contentDescription = null,
                            modifier=Modifier
                                .clickable {  }
                        )
                        Text(text = numLike.toString(),
                            modifier =Modifier
                                .padding(start=2.dp),
                            style = TextStyle(
                                fontWeight = FontWeight.ExtraBold,
                                color = MaterialTheme.colorScheme.background,
                                fontSize = 20.sp
                            ))
                    }
                }
                IconButton(
                    onClick = { /*TODO*/ }) {
                    Image(painter = painterResource(id = R.drawable.share), contentDescription = null)

                }
            }





            }
        }

    }





@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun Shower(){
    MoreView(image = R.drawable.ars_city)
}




