package ru.lab.kotlin.repository

import kotlinx.coroutines.flow.Flow
import ru.lab.kotlin.database.Result
import ru.lab.kotlin.database.ResultDao
import ru.lab.kotlin.repository.ResultRepository

class ResultRepositoryImpl(
    private val resultDao: ResultDao
) : ResultRepository {

    override suspend fun saveResultToDB(result: Result) = resultDao.insertResult(result)

    override fun getResults(): Flow<List<Result>> = resultDao.getAll()

    override suspend fun deleteAllResultsFromDB() = resultDao.deleteAll()

}