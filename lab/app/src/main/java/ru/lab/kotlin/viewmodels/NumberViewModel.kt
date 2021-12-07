package ru.lab.kotlin.viewmodels

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import ru.lab.kotlin.database.Result
import ru.lab.kotlin.repository.ResultRepository

class NumberViewModel(
    private val repository: ResultRepository
) : ViewModel() {

    private val _result = MutableLiveData<Double>()
    val result: LiveData<Double>
        get() = _result

    fun saveResult(result: Result) = viewModelScope.launch {
        repository.saveResultToDB(result)
    }
//счет
    fun calculateResultMultiply(x: Double, y: Double) = viewModelScope.launch {
        _result.value = x * y
    }

    fun calculateResultDivide(x: Double, y: Double) = viewModelScope.launch {
        _result.value = x / y
    }
//
    class Factory(private val repo: ResultRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(NumberViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return NumberViewModel(repo) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}