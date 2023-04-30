package com.myth.ticketmasterapp.data.spotifydatamodels

data class ItemX(
    val external_urls: ExternalUrlsX,
    val followers: Followers,
    val genres: List<String>,
    val href: String,
    val id: String,
    val images: List<Image>,
    val name: String,
    val popularity: Int,
    val type: String,
    val uri: String
)