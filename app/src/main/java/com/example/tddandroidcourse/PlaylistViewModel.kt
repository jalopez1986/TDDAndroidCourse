package com.example.tddandroidcourse

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PlaylistViewModel : ViewModel() {

    val playlists = MutableLiveData<Result<List<Playlist>>>()
}
