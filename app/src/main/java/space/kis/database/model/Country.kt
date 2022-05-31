package space.kis.database.model

import space.kis.database.room.CountryDbEntity

data class Country(
    val id: Long = 0,
    val countryName: String,
    val capitalName: String,
) {

    fun toCountryDbEntity() = CountryDbEntity(
        id = id,
        countryName = countryName,
        capitalName = capitalName,
    )

    override fun toString(): String {
        return "$countryName $capitalName"
    }
}