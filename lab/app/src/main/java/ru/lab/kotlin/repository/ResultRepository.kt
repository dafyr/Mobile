package ru.lab.kotlin.repository

import kotlinx.coroutines.flow.Flow
import ru.lab.kotlin.database.Result
//интерфес репозитория чтобы сделать новый репозиторий я должен наследоваться от этой штуки
interface ResultRepository {
    suspend fun saveResultToDB(result: Result)
    fun getResults(): Flow<List<Result>>
    suspend fun deleteAllResultsFromDB()
}