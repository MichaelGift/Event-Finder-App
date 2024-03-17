package com.myth.ticketmasterapp.data.datasrc

import com.myth.ticketmasterapp.data.spotifydatamodels.AccessTokenResponse
import com.myth.ticketmasterapp.data.spotifydatamodels.SpotifyData
import retrofit2.Call
import retrofit2.Response

interface RemoteSpotify {
    suspend fun getSpotifyData(authorization: String, artist: String): Response<SpotifyData>
    fun getAccessToken(authorization: String, grantType: String): Call<AccessTokenResponse>
}