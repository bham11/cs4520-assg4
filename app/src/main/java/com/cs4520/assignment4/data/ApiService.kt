package com.cs4520.assignment4.data

import com.cs4520.assignment4.model.Product
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(Api.ENDPOINT)
    suspend fun getProducts(@Query("page")page: Int): Call<List<Product>>
}