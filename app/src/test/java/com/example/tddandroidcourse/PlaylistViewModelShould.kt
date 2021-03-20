package com.example.tddandroidcourse

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.tddandroidcourse.utils.MainCoroutineScopeRule
import com.example.tddandroidcourse.utils.getValueForTest
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

import org.junit.Rule

class PlaylistViewModelShould {
    @get:Rule
    var coroutinesRule = MainCoroutineScopeRule()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val repository: PlaylistRepository = mock()

    private val playlists = mock<List<Playlist>>()
    private val expected = Result.success(playlists)

    @Test
    fun getPlaylistsFromRepository() = runBlockingTest {
        runBlocking {
            whenever(repository.getPlaylists()).thenReturn(
                flow {
                    emit(expected)
                }
            )
        }

        val viewModel = PlaylistViewModel(repository)

        viewModel.playlists.getValueForTest()

        verify(repository, times(1)).getPlaylists()
    }

    @Test
    fun emitsPlaylistsFromRepository() = runBlockingTest {
        runBlocking {
            whenever(repository.getPlaylists()).thenReturn(
                flow {
                    emit(expected)
                }
            )
        }

        val viewModel = PlaylistViewModel(repository)
        assertThat(viewModel.playlists.getValueForTest()).isEqualTo(expected)
    }
}