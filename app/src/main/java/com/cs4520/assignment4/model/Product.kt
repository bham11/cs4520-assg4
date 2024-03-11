package com.cs4520.assignment4.model

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






