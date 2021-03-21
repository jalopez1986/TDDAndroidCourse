package com.example.tddandroidcourse.playlist

import com.example.tddandroidcourse.playlist.Playlist
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PlaylistRepository @Inject constructor(
    private val service: PlaylistService,
    private val mapper: PlaylistMapper
) {
    suspend fun getPlaylists() : Flow<Result<List<Playlist>>> {
        return service.fetchPlaylists().map {
            if (it.isSuccess) {
                Result.success(mapper.execute(it.getOrNull()!!))
            } else {
                Result.failure(it.exceptionOrNull()!!)
            }
        }
    }
}
