package com.cs4520.assignment4.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cs4520.assignment4.model.Product


@Entity(tableName = "products_table")
data class Products(
    val name: String,
    val type: String,
    val expiryDate: String?,
    val price : Double,
    @PrimaryKey(autoGenerate = true) val id : Int
)

fun Products.toProduct(): Product {
    return Product(this.name, this.type, this.expiryDate, this.price)
}
