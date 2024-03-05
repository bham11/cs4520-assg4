package com.cs4520.assignment4.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("product/{productId}")
    suspend fun getProduct(@Path("productId")id: String): Call<Product>
}