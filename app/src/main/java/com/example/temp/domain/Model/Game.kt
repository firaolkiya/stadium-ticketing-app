package com.example.temp.domain.Model


data class Game(
    val gameId:Int,
    val club1:String,
    val club2:String,
    val remainTicket:Int,
    var isPlayed:Boolean?=false,
    var totalScore:Int?=0,
    var gameDate: String,
    var winner:Int?=null,
    var gameResult: Int?=null,
    val gamePlace: String
)