package com.example.tddandroidcourse.playlist

import com.example.tddandroidcourse.playlist.Playlist
import kotlinx.coroutines.flow.Flow

class PlaylistRepository {
    suspend fun getPlaylists() : Flow<Result<List<Playlist>>> {
        TODO("Not yet implemented")
    }

}
