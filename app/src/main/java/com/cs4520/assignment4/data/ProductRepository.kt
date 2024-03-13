package com.cs4520.assignment4.data


import android.app.Application
import android.util.Log
import com.cs4520.assignment4.data.database.Products
import com.cs4520.assignment4.data.database.ProductsDao
import com.cs4520.assignment4.data.database.ProductsDatabase
import com.cs4520.assignment4.data.database.toProduct
import com.cs4520.assignment4.model.Product
import com.cs4520.assignment4.model.isValidProduct
import com.cs4520.assignment4.model.toProducts

class ProductRepository(val productDao: ProductsDao) {
    private val apiService: ApiService = Api.apiService


    suspend fun getAllProducts(): List<Product> {
        try {

            val response = apiService.getProducts(null)
            if (response.isSuccessful) {

                val productList = this.filterValidProducts(response.body()?: emptyList())
                this.insertProductList(productList)
                return productList

            } else {
                Log.e("ProductRepository", "Failed to fetch products ${response.code()}")
                // fetch products from database when offline?
                val dbProducts = productDao.getAllProducts()
                return convertToProductList(dbProducts)

            }
        } catch (ex: Exception) {
            Log.e("ProductRepository", "Error getting products", ex)
        }
        return emptyList()
    }

    private fun filterValidProducts(productList: List<Product>): List<Product> {
        val productListCopy = productList.toList()
        productListCopy.filter { it.isValidProduct() }
        productListCopy.toSet()
        return productListCopy.toList()
    }

    private fun insertProductList(productList: List<Product>) {
        for(product in productList) {
            productDao.insert(product.toProducts())
        }

    }

    private fun convertToProductList(dbList: List<Products>): List<Product> {

        return dbList.map{ it.toProduct() }
    }



}