package ru.lab.kotlin

import android.app.Application
import ru.lab.kotlin.database.LabDatabase
import ru.lab.kotlin.repository.ResultRepositoryImpl

class LabApplication : Application() {

    private val database by lazy { LabDatabase.getDatabase(this) }

    val repository by lazy { ResultRepositoryImpl(database.resultDao()) }
}