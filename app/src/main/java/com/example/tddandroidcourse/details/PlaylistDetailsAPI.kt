package com.example.tddandroidcourse.details

import retrofit2.http.GET
import retrofit2.http.Path

interface PlaylistDetailsAPI {
    @GET("playlist-details/{id}")
    suspend fun fetchPlayDetailsById(@Path("id") id: String): PlaylistDetails

}
