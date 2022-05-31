package space.kis.database.room

import androidx.room.*

@Dao
interface CountryDao {

    @Query("SELECT * FROM country")
    fun getCountries(): List<CountryDbEntity>

    @Query("SELECT * FROM country WHERE country_name = :countryName AND capital_name = :secondName")
    fun getCountry(countryName: String, secondName: String): CountryDbEntity

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateCountry(countryDbEntity: CountryDbEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCountry(countryDbEntity: CountryDbEntity)

    @Delete
    fun deleteCountry(countryDbEntity: CountryDbEntity)
}