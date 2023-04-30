package com.myth.ticketmasterapp.data.eventdatamodels

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ExternalLinks(
    val facebook: List<com.myth.ticketmasterapp.data.eventdatamodels.Facebook>,
    val homepage: List<com.myth.ticketmasterapp.data.eventdatamodels.Homepage>,
    val instagram: List<com.myth.ticketmasterapp.data.eventdatamodels.Instagram>,
    val twitter: List<com.myth.ticketmasterapp.data.eventdatamodels.Twitter>,
    val wiki: List<com.myth.ticketmasterapp.data.eventdatamodels.Wiki>
):Parcelable