package com.myth.ticketmasterapp.data.eventdatamodels

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AgeRestrictions(
    val legalAgeEnforced: Boolean
):Parcelable