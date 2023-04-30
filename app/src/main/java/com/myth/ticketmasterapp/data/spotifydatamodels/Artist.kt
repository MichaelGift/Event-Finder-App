package com.myth.ticketmasterapp.data.spotifydatamodels

data class Artist(
    val external_urls: ExternalUrlsX,
    val href: String,
    val id: String,
    val name: String,
    val type: String,
    val uri: String
)