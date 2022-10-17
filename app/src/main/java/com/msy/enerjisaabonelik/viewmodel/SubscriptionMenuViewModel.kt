package com.msy.enerjisaabonelik.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.msy.enerjisaabonelik.di.models.Menu
import com.msy.enerjisaabonelik.di.retrofit.RetrofitRepository

class SubscriptionMenuViewModel: ViewModel() {

    private val repository = RetrofitRepository()

    val data = MutableLiveData<Menu>()

    fun loadMenu() {
        repository.getMovieData(data)
    }

}