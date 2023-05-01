package com.myth.ticketmasterapp.data.api

import com.myth.ticketmasterapp.data.spotifydatamodels.AccessTokenResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

interface SpotifyAuthService {
    @POST("token")
    @FormUrlEncoded
    fun getAccessToken(
        @Header("Authorization") authorization: String,
        @Field("grant_type") grantType: String
    ): Call<AccessTokenResponse>
}