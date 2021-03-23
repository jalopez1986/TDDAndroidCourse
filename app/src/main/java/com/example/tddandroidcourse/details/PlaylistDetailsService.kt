package com.example.tddandroidcourse.details

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import java.lang.RuntimeException
import javax.inject.Inject

class PlaylistDetailsService @Inject constructor(
        val api: PlaylistDetailsAPI
) {
    suspend fun fetchPlaylistDetails(id: String): Flow<Result<PlaylistDetails>> {
        return flow {
            emit(Result.success(api.fetchPlayDetailsById(id)))
        }.catch {
            emit(Result.failure(RuntimeException("Something went wrong")))
        }
    }

}
