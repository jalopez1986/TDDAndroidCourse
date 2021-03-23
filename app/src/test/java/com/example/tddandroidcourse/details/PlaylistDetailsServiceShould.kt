package com.example.tddandroidcourse.details

import com.example.tddandroidcourse.outsideinExample.unit.BaseUnitTest
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.test.runBlockingTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.lang.RuntimeException

class PlaylistDetailsServiceShould :BaseUnitTest() {
    private lateinit var service: PlaylistDetailsService
    private val api: PlaylistDetailsAPI = mock()
    private val playlistDetails: PlaylistDetails = mock()
    private val id = "1"

    @Test
    fun fetchPlaylistDetailsAPI() = runBlockingTest {
        mockSuccessfulCase()

        service.fetchPlaylistDetails(id).single()

        verify(api, times(1)).fetchPlayDetailsById(id)
    }

    @Test
    fun convertValuesToFlowResultAndEmitsThem() = runBlockingTest {
        mockSuccessfulCase()

        assertThat(service.fetchPlaylistDetails(id).single()).isEqualTo(Result.success(playlistDetails))
    }

    @Test
    fun emitsErrorResultWhenNetworkFails() = runBlockingTest {
        mockFailureCase()

        assertThat(service.fetchPlaylistDetails(id).single().exceptionOrNull()?.message).isEqualTo("Something went wrong")
    }


    private suspend fun mockSuccessfulCase() {
        whenever(api.fetchPlayDetailsById(id)).thenReturn(playlistDetails)

        service = PlaylistDetailsService(api)
    }

    private suspend fun mockFailureCase() {
        whenever(api.fetchPlayDetailsById(id)).thenThrow(RuntimeException("Damm backend developer"))

        service = PlaylistDetailsService(api)
    }


}