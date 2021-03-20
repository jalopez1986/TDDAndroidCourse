package com.example.tddandroidcourse.playlist

import androidx.lifecycle.*
import com.example.tddandroidcourse.playlist.Playlist
import com.example.tddandroidcourse.playlist.PlaylistRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class PlaylistViewModel(
    private val repository: PlaylistRepository
) : ViewModel() {

    //with liveDataBuilder (more cleaner)
    val playlists = liveData<Result<List<Playlist>>> {
        emitSource(repository.getPlaylists().asLiveData())
    }

    //without liveDataBuilder
    /*val playlists = MutableLiveData<Result<List<Playlist>>>()

    init {
        viewModelScope.launch {
            repository.getPlaylists().collect {
                playlists.value = it
            }
        }
    }*/
}
