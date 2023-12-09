package com.example.webdigitaltask.presentation.Car

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.webdigitaltask.data.repository.CarRepositoryImp
import com.example.webdigitaltask.domain.model.Car
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CarViewModel @Inject constructor (
    private val repo : CarRepositoryImp
) : ViewModel(){

    private val _state = mutableStateOf(CarState())
    val state : State<CarState> = _state

    init {
        getArticles()
    }

    private fun getArticles(){
       repo.selectedArticle().onEach {
            _state.value = _state.value.copy(articles = it.asReversed())
        }.launchIn(viewModelScope)   // we are collecting this
    }

    suspend fun deleteArticle(data: Car)
    {
        viewModelScope.launch(Dispatchers.IO) {
            repo.deleteArticle(data)
        }
    }

    suspend fun upsertarticle(article: Car) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.upsertArticle(article)
        }
    }

    suspend fun getAllArticle() {
       repo.selectedArticle()
    }
}