package com.myth.ticketmasterapp.data.datasrcimpl

import com.myth.ticketmasterapp.data.api.SpotifyAuthService
import com.myth.ticketmasterapp.data.api.SpotifyService
import com.myth.ticketmasterapp.data.datasrc.RemoteSpotify
import com.myth.ticketmasterapp.data.spotifydatamodels.AccessTokenResponse
import com.myth.ticketmasterapp.data.spotifydatamodels.SpotifyData
import retrofit2.Call
import retrofit2.Response

class RemoteSpotifyImplementation(
    private val spotifyService: SpotifyService,
    private val spotifyAuthService: SpotifyAuthService,
) : RemoteSpotify {
    override suspend fun getSpotifyData(authorizationToken: String, artist: String): Response<SpotifyData> =
        spotifyService.getArtist(authorizationToken, artist)

    override fun getAccessToken(
        authorization: String,
        grantType: String
    ): Call<AccessTokenResponse> = spotifyAuthService.getAccessToken(authorization, grantType)
}