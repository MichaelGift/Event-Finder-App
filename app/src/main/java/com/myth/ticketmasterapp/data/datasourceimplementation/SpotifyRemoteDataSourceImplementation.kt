package com.myth.ticketmasterapp.data.datasourceimplementation

import com.myth.ticketmasterapp.data.api.SpotifyAuthService
import com.myth.ticketmasterapp.data.api.SpotifyService
import com.myth.ticketmasterapp.data.datasource.SpotifyRemoteDataSource
import com.myth.ticketmasterapp.data.spotifydatamodels.AccessTokenResponse
import com.myth.ticketmasterapp.data.spotifydatamodels.SpotifyData
import retrofit2.Call
import retrofit2.Response

class SpotifyRemoteDataSourceImplementation(
    private val spotifyService: SpotifyService,
    private val spotifyAuthService: SpotifyAuthService,
) : SpotifyRemoteDataSource {
    override suspend fun getSpotifyData(authorizationToken: String, artist: String): Response<SpotifyData> =
        spotifyService.getArtist(authorizationToken, artist)

    override fun getAccessToken(
        authorization: String,
        grantType: String
    ): Call<AccessTokenResponse> = spotifyAuthService.getAccessToken(authorization, grantType)
}