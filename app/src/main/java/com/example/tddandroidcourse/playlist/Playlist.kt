package com.example.tddandroidcourse.playlist

import com.example.tddandroidcourse.R

data class Playlist(
    val id:String,
    val name: String,
    val category: String,
    val image: Int = R.mipmap.playlist
)