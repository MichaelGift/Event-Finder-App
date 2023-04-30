package com.myth.ticketmasterapp.data.spotifydatamodels

data class Artists(
    val href: String,
    val items: List<ItemX>,
    val limit: Int,
    val next: String,
    val offset: Int,
    val previous: Any,
    val total: Int
)