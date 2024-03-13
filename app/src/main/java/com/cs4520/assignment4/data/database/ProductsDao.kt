package com.cs4520.assignment4.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProductsDao {

    @Insert
    fun insert(products: Products)

    @Query("select * from products_table")
    fun getAllProducts(): List<Products>
}