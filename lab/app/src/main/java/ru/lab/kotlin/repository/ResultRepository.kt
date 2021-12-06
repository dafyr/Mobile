package ru.lab.kotlin.repository

import kotlinx.coroutines.flow.Flow
import ru.lab.kotlin.database.Result

interface ResultRepository {
    suspend fun saveResultToDB(result: Result)
    fun getResults(): Flow<List<Result>>
    suspend fun deleteAllResultsFromDB()
}