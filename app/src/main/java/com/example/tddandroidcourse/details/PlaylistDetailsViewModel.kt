package com.example.tddandroidcourse.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch


class PlaylistDetailsViewModel(
        private val service: PlaylistDetailsService
) : ViewModel() {
    val loader = MutableLiveData<Boolean>()

    val playlistDetails = MutableLiveData<Result<PlaylistDetails>>()

    fun getPlaylistDetails(id: String) {
        viewModelScope.launch {
            loader.postValue(true)
            service.fetchPlaylistDetails(id)
                    .onEach {
                        loader.postValue(false)
                    }
                    .collect {
                        playlistDetails.postValue(it)
                    }
        }
    }

}
