package com.example.tddandroidcourse.playlist

import com.example.tddandroidcourse.R
import kotlinx.android.synthetic.main.playlist_item.view.*
import javax.inject.Inject

class PlaylistMapper @Inject constructor()  {
    fun execute(playlistsRaw: List<PlaylistRaw>): List<Playlist> {
        return playlistsRaw.map {
            val image = when(it.category) {
                "rock" -> R.mipmap.rock
                else -> R.mipmap.playlist
            }
            Playlist(it.id, it.name, it.category, image)
        }
    }


}
