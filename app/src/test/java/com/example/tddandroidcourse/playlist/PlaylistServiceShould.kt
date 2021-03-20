package com.example.tddandroidcourse.playlist

import com.example.tddandroidcourse.outsideinExample.unit.BaseUnitTest
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runBlockingTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.lang.RuntimeException

class PlaylistServiceShould : BaseUnitTest() {

    private lateinit var service: PlaylistService
    private val api: PlaylistAPI = mock()
    private val playlists: List<Playlist> = mock()

    @Test
    fun fetchPlayListsFromAPI() = runBlockingTest {
        service = PlaylistService(api)

        service.fetchPlaylists().first()

        verify(api, times(1)).fetchAllPlaylists()

    }

    @Test
    fun convertValuesToFlowResultAndEmitsThem() = runBlockingTest {
        mockSuccessfulCase()

        assertThat(service.fetchPlaylists().first()).isEqualTo(Result.success(playlists))
    }


    @Test
    fun emitsErrorResultWhenNetworkFails() = runBlockingTest {
        mockFailureCase()

        assertThat(service.fetchPlaylists().first().exceptionOrNull()?.message).isEqualTo("Something went wrong")
    }

    private suspend fun mockSuccessfulCase() {
        whenever(api.fetchAllPlaylists()).thenReturn(playlists)

        service = PlaylistService(api)
    }

    private suspend fun mockFailureCase() {
        whenever(api.fetchAllPlaylists()).thenThrow(RuntimeException("Damm backend developer"))

        service = PlaylistService(api)
    }
}
