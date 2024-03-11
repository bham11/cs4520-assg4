package com.cs4520.assignment4.data


import android.util.Log
import com.cs4520.assignment4.model.Product

class ProductRepository(private val apiService: ApiService) {

//    private val database = ProductsDatabase.getInstance(application)

    suspend fun getAllProducts(): List<Product> {
        val response = apiService.getProducts(1)
        if (response.isSuccessful) {
            return response.body() ?: emptyList()

        } else {
            Log.w("myapp", "Attempting gathering data from Database")
            throw Exception("Error Getting Products ${response.code()}")

        }


    }


}