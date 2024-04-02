package com.myth.ticketmasterapp.data.eventmodels

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ExternalLinks(
    val facebook: List<com.myth.ticketmasterapp.data.eventmodels.Facebook>,
    val homepage: List<com.myth.ticketmasterapp.data.eventmodels.Homepage>,
    val instagram: List<com.myth.ticketmasterapp.data.eventmodels.Instagram>,
    val twitter: List<com.myth.ticketmasterapp.data.eventmodels.Twitter>,
    val wiki: List<com.myth.ticketmasterapp.data.eventmodels.Wiki>
):Parcelable