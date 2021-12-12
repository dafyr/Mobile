package ru.lab.kotlin.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
//описываем директивы для работы с таблицами
@Dao
interface ResultDao {
    @Insert
    suspend fun insertResult(result: Result)

    @Query("SELECT * FROM result_table")
    fun getAll(): Flow<List<Result>>

    @Query("DELETE FROM result_table")
    suspend fun deleteAll()
}