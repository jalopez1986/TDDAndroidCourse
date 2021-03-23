package com.example.tddandroidcourse.details

import com.example.tddandroidcourse.playlist.client
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(FragmentComponent::class)
class PlaylistDetailsModule {
    @Provides
    fun playlistDetailsAPI(retrofit: Retrofit) : PlaylistDetailsAPI = retrofit.create(PlaylistDetailsAPI::class.java)
}