package space.kis.database.repositary

import space.kis.database.model.Country

interface Repository {

    fun getAll(): List<Country>

    fun deleteCountry(country: Country)

    fun insertCountry(country: Country)

    fun updateCountry(oldCountry: Country, newCountry: Country)
}