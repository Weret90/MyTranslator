package com.umbrella.mytranslator.di

import androidx.room.Room
import com.umbrella.mytranslator.data.database.WordsDatabase
import org.koin.dsl.module

private const val DB_NAME = "words.db"

val roomModule = module {
    single {
        Room.databaseBuilder(get(), WordsDatabase::class.java, DB_NAME)
            .build()
            .wordsDao()
    }
}