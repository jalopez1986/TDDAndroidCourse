package com.example.tddandroidcourse.playlist

import com.example.tddandroidcourse.outsideinExample.unit.BaseUnitTest
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runBlockingTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class PlaylistRepositoryShould : BaseUnitTest() {

    private val service: PlaylistService = mock()
    private val playlists = mock<List<Playlist>>()


    @Test
    fun getPlaylistsFromService() = runBlockingTest {

        val repository = PlaylistRepository(service)

        repository.getPlaylists()

        verify(service,times(1)).fetchPlaylists()
    }

    @Test
    fun emitPlaylistsFromService() = runBlockingTest {
        val repository = mockSuccessfulCase()

        assertThat(repository.getPlaylists().first().getOrNull() ).isEqualTo(playlists)
    }

    private suspend fun mockSuccessfulCase(): PlaylistRepository {
        whenever(service.fetchPlaylists()).thenReturn(
            flow {
                emit(Result.success(playlists))
            }
        )

        val repository = PlaylistRepository(service)
        return repository
    }


}