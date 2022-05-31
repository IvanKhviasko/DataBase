package space.kis.database.repositary

import space.kis.database.model.Country
import space.kis.database.room.CountryDao
import space.kis.database.room.CountryDbEntity

class CountryRepository(
    private val capitalDao: CountryDao
) : Repository {

    override fun getAll(): List<Country> {
        val countryDbEntityList = capitalDao.getCountries()
        val countryList = countryDbEntityList.map {
            it.toCountry()
        }
        return countryList
    }

    override fun deleteCountry(country: Country) {
        val countryDbEntity = getCountry(country.countryName, country.capitalName)
        capitalDao.deleteCountry(countryDbEntity)
    }

    override fun insertCountry(country: Country) {
        val countryDbEntity = country.toCountryDbEntity()
        capitalDao.insertCountry(countryDbEntity)
    }

    override fun updateCountry(oldCountry: Country, newCountry: Country) {
        val countryDbEntity = getCountry(oldCountry.countryName, oldCountry.capitalName)
        countryDbEntity.countryName = newCountry.countryName
        countryDbEntity.capitalName = newCountry.capitalName
        capitalDao.updateCountry(countryDbEntity)
    }

    private fun getCountry(countryName: String, capitalName: String): CountryDbEntity {
        return capitalDao.getCountry(countryName, capitalName)
    }
}