package com.cs4520.assignment4.model

import com.cs4520.assignment4.data.database.Products
import com.google.gson.annotations.SerializedName

data class Product (
    @SerializedName("name")
    val name: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("expiryDate")
    val expiryDate: String?,
    @SerializedName("price")
    val price : Double,

)

fun Product.toProducts(): Products {
    return Products(this.name,this.type,this.expiryDate, this.price,0)
}

fun Product.isValidProduct(): Boolean {
    // whole product not shown?
    //Products in json can have empty or missing data. This should not be shown on UI.
    return name.isNotEmpty() && type.isNotEmpty() && price.toString().isNotEmpty()
}






