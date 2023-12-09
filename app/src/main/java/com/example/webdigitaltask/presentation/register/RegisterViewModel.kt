package com.example.webdigitaltask.presentation.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.webdigitaltask.data.remote.dto.logindto.Login
import com.example.webdigitaltask.data.remote.dto.logindto.LoginResponse
import com.example.webdigitaltask.data.remote.dto.registerdto.Register
import com.example.webdigitaltask.data.remote.dto.registerdto.RegisterResponse
import com.example.webdigitaltask.data.repository.CarRepositoryImp
import com.example.webdigitaltask.util.Resource
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.message
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val repo: CarRepositoryImp) : ViewModel() {
    private val _registerData  = MutableLiveData<Resource<RegisterResponse>>()
    val registerData : LiveData<Resource<RegisterResponse>> = _registerData

    fun register(data: Register)
    {
        viewModelScope.launch(Dispatchers.IO) {
            when(val data = repo.registerUser(data))
            {
                is ApiResponse.Failure ->{_registerData.postValue(Resource.Error(data.message().toString()))}
                is ApiResponse.Success ->{_registerData.postValue(Resource.Success(data.data))}
            }
        }
    }
}