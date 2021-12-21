package com.umbrella.mytranslator.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.umbrella.mytranslator.data.model.database.SimpleWordDatabaseModel

@Dao
interface WordsDao {

    @Query("SELECT * FROM words")
    fun getAllWords(): LiveData<List<SimpleWordDatabaseModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWord(word: SimpleWordDatabaseModel)

    @Query("DELETE FROM words")
    suspend fun deleteAllWords()
}