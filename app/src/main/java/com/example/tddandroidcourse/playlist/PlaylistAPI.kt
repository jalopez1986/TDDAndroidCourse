package com.example.tddandroidcourse.playlist

import retrofit2.http.GET

interface PlaylistAPI {
    @GET("playlists")
    suspend fun fetchAllPlaylists() : List<PlaylistRaw>


}
