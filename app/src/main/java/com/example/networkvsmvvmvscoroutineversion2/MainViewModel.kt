package com.example.networkvsmvvmvscoroutineversion2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.awaitResponse

class MainViewModel : ViewModel() {
    val retroModel : MutableLiveData<RetroModel> by lazy {
        MutableLiveData<RetroModel>()
    }

    fun getData(key : String){
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetroInstance.api.getDataFromAPI(key).awaitResponse()
            if(response.isSuccessful){
                val model = response.body()
                withContext(Dispatchers.Main){
                    retroModel.value = model
                }

            }
        }
    }
}