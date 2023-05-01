package com.myth.ticketmasterapp.data.api

import com.myth.ticketmasterapp.data.spotifydatamodels.SpotifyData
import retrofit2.Response
import retrofit2.http.*

interface SpotifyService {
    @GET("search")
    suspend fun getArtist(
        @Header("Authorization") authorization: String,
        @Query("q") artistName: String,
        @Query("type") type: String = "artist,album",
        @Query("limit") limit: Int = 3
    ): Response<SpotifyData>
}
