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
import java.lang.RuntimeException

class PlaylistRepositoryShould : BaseUnitTest() {
    private val service: PlaylistService = mock()
    private val mapper: PlaylistMapper = mock()
    private val playlists = mock<List<Playlist>>()
    private val playlistsRaw = mock<List<PlaylistRaw>>()
    private val exception = RuntimeException("Something went wrong")

    @Test
    fun getPlaylistsFromService() = runBlockingTest {

        val repository = mockSuccessfulCase()

        repository.getPlaylists()

        verify(service,times(1)).fetchPlaylists()
    }

    @Test
    fun emitMapperPlaylistsFromService() = runBlockingTest {
        val repository = mockSuccessfulCase()

        assertThat(repository.getPlaylists().first().getOrNull() ).isEqualTo(playlists)
    }

    @Test
    fun propagateErrors() = runBlockingTest {
        val repository = mockFailureTest()

        assertThat(repository.getPlaylists().first().exceptionOrNull()).isEqualTo(exception)
    }

    @Test
    fun delegateBusinessLogicToMapper() = runBlockingTest {
        val repository = mockSuccessfulCase()

        repository.getPlaylists().first()

        verify(mapper, times(1)).execute(playlistsRaw)
    }


    private suspend fun mockSuccessfulCase(): PlaylistRepository {
        whenever(service.fetchPlaylists()).thenReturn(
            flow {
                emit(Result.success(playlistsRaw))
            }
        )

        whenever(mapper.execute(playlistsRaw)).thenReturn(playlists)

        return PlaylistRepository(service, mapper)
    }

    private suspend fun mockFailureTest(): PlaylistRepository {
        whenever(service.fetchPlaylists()).thenReturn(
            flow {
                emit(Result.failure<List<PlaylistRaw >>(exception))
            }
        )

        return PlaylistRepository(service, mapper)
    }


}