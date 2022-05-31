package space.kis.database.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import space.kis.database.model.Country

@Entity(tableName = "country")
data class CountryDbEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo(name = "country_name")
    var countryName: String,
    @ColumnInfo(name = "capital_name")
    var capitalName: String,
) {

    fun toCountry(): Country = Country(
        id = id,
        countryName = countryName,
        capitalName = capitalName,
    )
}