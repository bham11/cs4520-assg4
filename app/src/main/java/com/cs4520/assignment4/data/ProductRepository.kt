package com.cs4520.assignment4.data


import retrofit2.awaitResponse

class ProductRepository {
    private val apiService = Api.apiService

    suspend fun getAllProducts(): List<Product> {
        return try {
            val response = apiService.getProducts(1).awaitResponse()
            if (response.isSuccessful) {
                val products = response.body() ?: emptyList()
                products

            } else {
                emptyList()

            }
        } catch (exception: Exception) {
            val e = exception
            emptyList()
        }
    }


}