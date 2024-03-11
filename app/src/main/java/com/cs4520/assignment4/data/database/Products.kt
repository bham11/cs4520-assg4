package com.cs4520.assignment4.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "products_table")
data class Products(
    val name: String,
    val type: String,
    val expiryDate: String?,
    val price : Double,
    @PrimaryKey(autoGenerate = true) val id : Int
)
