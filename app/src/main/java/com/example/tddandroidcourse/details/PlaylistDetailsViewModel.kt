package com.example.tddandroidcourse.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import java.util.concurrent.Flow

class PlaylistDetailsViewModel(
        private val service: PlaylistDetailsService
) : ViewModel() {
    val playlistDetails = MutableLiveData<Result<PlaylistDetails>>()

    fun getPlaylistDetails(id: String) {
        viewModelScope.launch {
            service.fetchPlaylistDetails(id)
                    .collect {
                        playlistDetails.postValue(it)
                    }
        }
    }

}
