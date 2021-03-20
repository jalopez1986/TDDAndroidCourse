package com.example.tddandroidcourse.playlist

import com.example.tddandroidcourse.playlist.Playlist
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PlaylistRepository(
    private val service: PlaylistService
) {
    suspend fun getPlaylists() : Flow<Result<List<Playlist>>> {
        return service.fetchPlaylists()
    }
}
