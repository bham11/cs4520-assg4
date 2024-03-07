package com.cs4520.assignment4.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.cs4520.assignment4.model.Product

@Dao
interface ProductsDao {

    @Insert
    fun insert(product: Product)

    @Query("select * from products")
    fun getAllProducts(): LiveData<List<Product>>
}