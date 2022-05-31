package space.kis.database.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CountryDbEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun countryDao(): CountryDao
}