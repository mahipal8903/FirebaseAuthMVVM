package com.example.demoproject.dashboard

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("coffee/hot")
    fun getHotCoffees(): Call<List<Coffee>>
}