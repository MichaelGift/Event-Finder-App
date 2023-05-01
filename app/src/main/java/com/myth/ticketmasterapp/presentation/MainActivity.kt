package com.myth.ticketmasterapp.presentation

import android.os.Bundle
import android.util.Base64
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.myth.ticketmasterapp.BuildConfig
import com.myth.ticketmasterapp.R
import com.myth.ticketmasterapp.data.spotifydatamodels.AccessTokenResponse
import com.myth.ticketmasterapp.databinding.ActivityMainBinding
import com.myth.ticketmasterapp.presentation.di.Injector
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ViewModelFactory
    lateinit var eventViewModel: EventViewModel
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        (application as Injector).createEventSubComponent().inject(this)
        eventViewModel = ViewModelProvider(this, factory)[EventViewModel::class.java]

        val clientId = "7fdd006b6650427b803f093a9a32d629"
        val clientSecret = "18fb2aae194f4d5ea6aa95a6d5006e07"

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