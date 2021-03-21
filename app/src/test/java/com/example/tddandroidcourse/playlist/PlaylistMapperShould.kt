package com.example.tddandroidcourse.playlist

import com.example.tddandroidcourse.R
import com.example.tddandroidcourse.outsideinExample.unit.BaseUnitTest
import kotlinx.android.synthetic.main.playlist_item.view.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class PlaylistMapperShould : BaseUnitTest() {

    private val playlistRaw = PlaylistRaw("1", "name", "category")
    private val playlistRawRock = PlaylistRaw("1", "name", "rock")

    private val mapper = PlaylistMapper()

    private val playlist = mapper.execute(listOf(playlistRaw)).first()
    private val playlistRock = mapper.execute(listOf(playlistRawRock)).first()

    @Test
    fun keepSameId() {
        assertThat(playlist.id).isEqualTo(playlistRaw.id)
    }

    @Test
    fun keepSameName() {
        assertThat(playlist.name).isEqualTo(playlistRaw.name)
    }

    @Test
    fun keepSameCategory() {
        assertThat(playlist.category).isEqualTo(playlistRaw.category)
    }

    @Test
    fun mapDefaultImageWhenNotRock() {
        assertThat(playlistRock.image).isEqualTo(R.mipmap.rock)
    }

}