package com.myth.ticketmasterapp.data.eventmodels

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Entity(tableName = "events")
@Parcelize
data class Event(
    @SerializedName("_embedded")
    val venueData: VenueData,
    val classifications: List<Classification>,
    val dates: Dates,
    @PrimaryKey
    val id: String,
    val posters: List<Posters>,
    val info: String,
    val locale: String,
    val name: String,
    val pleaseNote: String,
    val priceRanges: List<PriceRange>,
    val promoters: List<Promoter>,
    val ticketSales: Sales,
    val seatmap: Seatmap,
    val type: String,
    val url: String
) : Parcelable{
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Event

        if (id != other.id) return false
        if (venueData != other.venueData) return false
        if (classifications != other.classifications) return false
        if (dates != other.dates) return false
        if (posters != other.posters) return false
        if (info != other.info) return false
        if (locale != other.locale) return false
        if (name != other.name) return false
        if (pleaseNote != other.pleaseNote) return false
        if (priceRanges != other.priceRanges) return false
        if (promoters != other.promoters) return false
        if (ticketSales != other.ticketSales) return false
        if (seatmap != other.seatmap) return false
        if (test != other.test) return false
        if (type != other.type) return false
        if (url != other.url) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (type?.hashCode() ?: 0)
        result = 31 * result + (test?.hashCode() ?: 0)
        return result
    }
}