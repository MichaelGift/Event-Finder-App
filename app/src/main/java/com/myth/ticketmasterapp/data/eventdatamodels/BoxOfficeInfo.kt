package com.myth.ticketmasterapp.data.eventdatamodels

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BoxOfficeInfo(
    val acceptedPaymentDetail: String,
    val openHoursDetail: String,
    val phoneNumberDetail: String,
    val willCallDetail: String
):Parcelable