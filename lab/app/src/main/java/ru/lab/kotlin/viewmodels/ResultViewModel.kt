package ru.lab.kotlin.viewmodels

import androidx.lifecycle.*
import ru.lab.kotlin.repository.ResultRepository

class ResultViewModel(
    repository: ResultRepository
) : ViewModel() {

    val results = repository.getResults().asLiveData()

    class Factory(private val repo: ResultRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ResultViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return ResultViewModel(repo) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}