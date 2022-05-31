package space.kis.database

import android.content.Context
import androidx.room.Room
import space.kis.database.repositary.CountryRepository
import space.kis.database.room.AppDataBase

object Repositories {

    private lateinit var applicationContext: Context

    private val dataBase: AppDataBase by lazy {
        Room.databaseBuilder(applicationContext, AppDataBase::class.java, "database-room")
            .allowMainThreadQueries()
            .build()
    }

    val COUNTRY_REPOSITORY: CountryRepository by lazy {
        CountryRepository(dataBase.countryDao())
    }

    fun init(context: Context) {
        applicationContext = context
    }
}