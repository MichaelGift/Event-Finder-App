package com.myth.ticketmasterapp.data.api

import com.myth.ticketmasterapp.data.spotifydatamodels.SportifyData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface SpotifyService {
    @GET("search")
    suspend fun getArtist(
        @Header("Authorization") authorization: String,
        @Query("query") artistName: String,
        @Query("type") type: String = "artist%2Calbum",
        @Query("limit") limit: Int = 3
    ): Response<SportifyData>
}
