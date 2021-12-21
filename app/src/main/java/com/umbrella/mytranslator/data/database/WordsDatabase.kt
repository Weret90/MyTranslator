package com.umbrella.mytranslator.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.umbrella.mytranslator.data.model.database.SimpleWordDatabaseModel

@Database(entities = [SimpleWordDatabaseModel::class], version = 1, exportSchema = false)
abstract class WordsDatabase : RoomDatabase() {

    abstract fun wordsDao(): WordsDao
}