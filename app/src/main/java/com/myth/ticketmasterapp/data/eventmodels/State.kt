package com.myth.ticketmasterapp.data.eventmodels

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class State(
    val name: String,
    val stateCode: String
):Parcelable