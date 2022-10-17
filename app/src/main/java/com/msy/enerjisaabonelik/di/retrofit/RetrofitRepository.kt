package com.msy.enerjisaabonelik.di.retrofit

import androidx.lifecycle.MutableLiveData
import com.msy.enerjisaabonelik.di.models.Menu
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitRepository {

    fun getMenuData(liveData: MutableLiveData<Menu>) {


        val apiService = RetrofitServiceInstance.getInstance().create(GetDataService::class.java)
        apiService.getMenu().enqueue(object : Callback<Menu> {
            override fun onResponse(call: Call<Menu>, response: Response<Menu>) {
                liveData.postValue(response.body())
            }

            override fun onFailure(call: Call<Menu>, t: Throwable) {
                liveData.postValue(null)
            }
        })
    }
}