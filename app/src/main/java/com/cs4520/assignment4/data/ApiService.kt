package com.cs4520.assignment4.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("product")
    suspend fun getProducts(@Query("page")page: Int): Call<List<Product>>
}