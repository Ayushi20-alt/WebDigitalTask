package com.example.webdigitaltask.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.webdigitaltask.data.remote.dto.logindto.Login
import com.example.webdigitaltask.data.remote.dto.logindto.LoginResponse
import com.example.webdigitaltask.data.repository.CarRepositoryImp
import com.example.webdigitaltask.util.Resource
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.message
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repo: CarRepositoryImp) :ViewModel() {
    private val _loginData  = MutableLiveData<Resource<LoginResponse>>()
    val loginData : LiveData<Resource<LoginResponse>> = _loginData

    val coroutineExceptionHandler = CoroutineExceptionHandler{_, throwable ->
        throwable.printStackTrace()
    }

    fun login(data:Login)
    {
        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            when(val data = repo.loginUser(data))
            {
                is ApiResponse.Failure ->{_loginData.postValue(Resource.Error(data.message().toString()))}
                is ApiResponse.Success ->{_loginData.postValue(Resource.Success(data.data))}
            }
        }
    }
}