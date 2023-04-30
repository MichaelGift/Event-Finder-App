package com.myth.ticketmasterapp.data.datasource

import com.myth.ticketmasterapp.data.spotifydatamodels.Artist

interface SpotifyRemoteDataSource {
    suspend fun getSpotifyData(artist: String)
}