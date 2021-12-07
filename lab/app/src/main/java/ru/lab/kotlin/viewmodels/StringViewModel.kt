package ru.lab.kotlin.viewmodels

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.lab.lab5.R
//анализирует данные и записывает в модель
class StringViewModel : ViewModel() {

    private val _result = MutableLiveData<String>()
    val result: LiveData<String>
        get() = _result

    fun doHello(resources: Resources, text: String) = viewModelScope.launch {
        _result.value = resources.getString(R.string.hello, text)
    }

}