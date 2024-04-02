package com.myth.ticketmasterapp.data.eventmodels

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Sales(
    val presales: List<com.myth.ticketmasterapp.data.eventmodels.Presale>,
    val public: com.myth.ticketmasterapp.data.eventmodels.Public
):Parcelable