package com.umbrella.mytranslator.data.model.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "words")
data class SimpleWordDatabaseModel(
    @PrimaryKey
    val word: String
)