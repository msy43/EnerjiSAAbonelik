package com.msy.enerjisaabonelik.di.retrofit

import com.msy.enerjisaabonelik.di.models.Menu
import retrofit2.Call
import retrofit2.http.GET

interface GetDataService {

    @GET("bydevelopertr/enerjisa/main/menu.json")
    fun getMenu(): Call<Menu>

}