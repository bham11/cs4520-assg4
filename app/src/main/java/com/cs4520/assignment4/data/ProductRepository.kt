package com.cs4520.assignment4.data


import android.app.Application
import android.util.Log
import com.cs4520.assignment4.data.database.ProductsDatabase
import com.cs4520.assignment4.model.Product
import com.cs4520.assignment4.model.toProducts

class ProductRepository() {
    private val apiService: ApiService = Api.apiService
//    private val database = ProductsDatabase.getInstance(app)

    suspend fun getAllProducts(): List<Product> {
        try {
            val response = apiService.getProducts(null)
            if (response.isSuccessful) {
//            for(product in response.body()!!) {
//                database.productDao().insert(product.toProducts())
//            }
                // filter products for missing values and dupes
                return response.body() ?: emptyList()

            } else {
                Log.e("ProductRepository", "Failed to fetch products ${response.code()}")
                // fetch products from database
            }
        } catch (ex: Exception) {
            Log.e("ProductRepository", "Error getting products", ex)
        }
        return emptyList()
    }



}