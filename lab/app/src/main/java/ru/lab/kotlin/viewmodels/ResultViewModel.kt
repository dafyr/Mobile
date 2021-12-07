package ru.lab.kotlin.viewmodels

import androidx.lifecycle.*
import ru.lab.kotlin.repository.ResultRepository
//прослойка которая отвечает за оперрирование данных между предаставлением модели и интерфейсом
class ResultViewModel(
    repository: ResultRepository
) : ViewModel() {

    val results = repository.getResults().asLiveData()

    class Factory(private val repo: ResultRepository) : ViewModelProvider.Factory { // паттерн абстрактной фабрики
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ResultViewModel::class.java)) {     // пораждает класса вьюмодели конструктор
                @Suppress("UNCHECKED_CAST")
                return ResultViewModel(repo) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}