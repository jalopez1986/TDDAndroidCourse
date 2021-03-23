package com.example.tddandroidcourse.details

import com.example.tddandroidcourse.outsideinExample.unit.BaseUnitTest
import com.example.tddandroidcourse.utils.captureValues
import com.example.tddandroidcourse.utils.getValueForTest
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runBlockingTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.lang.RuntimeException

class PlaylistDetailsViewModelShould : BaseUnitTest() {
    lateinit var viewModel: PlaylistDetailsViewModel
    private val id: String = "1"
    private val service: PlaylistDetailsService = mock()
    private val playlistDetails: PlaylistDetails = mock()
    private val expected = Result.success(playlistDetails)
    private val exception = RuntimeException("Something went wrong")


    @Test
    fun getPlaylistDetailsFromService() = runBlockingTest {
        mockSuccessfulCase()
        viewModel.getPlaylistDetails(id)

        viewModel.playlistDetails.getValueForTest()

        verify(service, times(1)).fetchPlaylistDetails(id)
    }

    @Test
    fun emitPlaylistDetailsFromService() = runBlockingTest {
        mockSuccessfulCase()
        viewModel.getPlaylistDetails(id)

        assertThat(viewModel.playlistDetails.getValueForTest()).isEqualTo(expected)
    }

    @Test
    fun emitErrorWhenServiceFails() {
        mockErrorCase()
        viewModel.getPlaylistDetails(id)

        //assertThat(viewModel.playlistDetails.getValueForTest()!!.exceptionOrNull()).isEqualTo(exception)

    }

    @Test
    fun showSpinnerWhileLoading() = runBlockingTest {
        mockSuccessfulCase()

        viewModel.loader.captureValues {
            viewModel.getPlaylistDetails(id)
            viewModel.playlistDetails.getValueForTest()

            assertThat(values[0]).isTrue()
        }
    }

    @Test
    fun closeLoaderAfterPlaylistDetailsLoad() = runBlockingTest {
        mockSuccessfulCase()

        viewModel.loader.captureValues {
            viewModel.getPlaylistDetails(id)
            viewModel.playlistDetails.getValueForTest()

            assertThat(values.last()).isFalse()
        }
    }



    private suspend fun mockSuccessfulCase() {
        whenever(service.fetchPlaylistDetails(id)).thenReturn(
                flow {
                    emit(expected)
                }
        )

        viewModel = PlaylistDetailsViewModel(service)
    }

    private fun mockErrorCase() = runBlockingTest {
        whenever(service.fetchPlaylistDetails(id)).thenReturn(
                flow {
                    emit(Result.failure<PlaylistDetails>(exception))
                }
        )

        viewModel = PlaylistDetailsViewModel(service)
    }
}