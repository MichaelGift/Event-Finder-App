package com.myth.ticketmasterapp.presentation

import android.os.Bundle
import android.util.Base64
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.myth.ticketmasterapp.BuildConfig
import com.myth.ticketmasterapp.R
import com.myth.ticketmasterapp.data.spotifydatamodels.AccessTokenResponse
import com.myth.ticketmasterapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val eventViewModel: EventViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val clientId = "(Insert Spotify Client Id)"
        val clientSecret = "(Insert Spotify Client Secret)"

        val authHeader = "Basic " + Base64.encodeToString(
            "$clientId:$clientSecret".toByteArray(),
            Base64.NO_WRAP
        )

        eventViewModel.getAccessToken(authHeader, "client_credentials")
            .enqueue(object : Callback<AccessTokenResponse> {
                override fun onResponse(
                    call: Call<AccessTokenResponse>,
                    response: Response<AccessTokenResponse>
                ) {
                    if (response.isSuccessful) {
                        val accessToken = response.body()?.accessToken
                        if (accessToken != null) {
                            eventViewModel.accessToken = accessToken
                        }

                        Log.d("Access Token Request", "Access Token Received : $accessToken")
                    } else {
                        Log.d("Access Token Request", "Error Response: ${response.code()}")
                    }
                }

                override fun onFailure(call: Call<AccessTokenResponse>, t: Throwable) {
                    Log.d("Access Token Request", "Error getting access token", t)
                }
            })


        beginRequestLogging()
    }

    private fun beginRequestLogging() {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()

        val retrofit =
            Retrofit.Builder().baseUrl(BuildConfig.SPOTIFY_BASE_URL).client(client).build()
    }

}
