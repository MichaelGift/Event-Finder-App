package com.myth.ticketmasterapp.domain.usecases

import com.myth.ticketmasterapp.data.spotifydatamodels.AccessTokenResponse
import com.myth.ticketmasterapp.data.spotifydatamodels.SpotifyData
import com.myth.ticketmasterapp.domain.repository.EventRepository
import retrofit2.Call

class GetSpotifyDataUseCase(private var eventRepository: EventRepository) {
    suspend fun execute(authorization: String,artist: String): List<SpotifyData>? =
        eventRepository.getSpotifyData(authorization,artist)

    fun getAccessToken(authorization: String, grantToken: String): Call<AccessTokenResponse> =
        eventRepository.getAccessToken(authorization, grantToken)

}