package com.myth.ticketmasterapp.data.eventdatamodels

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "events")
@Parcelize
data class Event(
    val _embedded: EmbeddedX,
    val ageRestrictions: AgeRestrictions,
    val classifications: List<ClassificationX>,
    val dates: Dates,
    @PrimaryKey
    val id: String,
    val images: List<ImageXX>,
    val info: String,
    val locale: String,
    val name: String,
    val pleaseNote: String,
    val priceRanges: List<PriceRange>,
    val promoters: List<Promoter>,
    val sales: Sales,
    val seatmap: Seatmap,
    val test: Boolean,
    val type: String,
    val url: String
) : Parcelable{
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Event

        if (id != other.id) return false
        if (_embedded != other._embedded) return false
        if (ageRestrictions != other.ageRestrictions) return false
        if (classifications != other.classifications) return false
        if (dates != other.dates) return false
        if (images != other.images) return false
        if (info != other.info) return false
        if (locale != other.locale) return false
        if (name != other.name) return false
        if (pleaseNote != other.pleaseNote) return false
        if (priceRanges != other.priceRanges) return false
        if (promoters != other.promoters) return false
        if (sales != other.sales) return false
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