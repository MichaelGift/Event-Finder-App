package com.myth.ticketmasterapp.data.datasourceimplementation

import com.myth.ticketmasterapp.data.api.SpotifyService
import com.myth.ticketmasterapp.data.datasource.SpotifyRemoteDataSource

class SpotifyRemoteDataSourceImplementation(
    private val spotifyService: SpotifyService,
    private val authorizationToken: String,
    private val artistName: String = ""
) : SpotifyRemoteDataSource {
    override suspend fun getSpotifyData(artist: String) {
        spotifyService.getArtist(authorizationToken, artistName)
    }


}