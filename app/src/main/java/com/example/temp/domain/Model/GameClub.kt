package com.example.temp.domain.Model

data class GameClub(
    val clubId:Int,
    var clubName:String,
    val totalGoal:Int,
    var member:List<String>,
    var GameList:List<Game>?=null,
)