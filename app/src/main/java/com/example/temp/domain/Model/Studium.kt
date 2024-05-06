package com.example.temp.domain

data class Stadium(
    val stadiumId:Int,
    var numberOfSet:Int,
    var capacity:Int,
    val stadiumName: String,
    val location:String
)