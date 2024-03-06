package com.cs4520.assignment4.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "products")
data class Product (
    @SerializedName("name")
    val name: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("expiryDate")
    val expiryDate: String?,
    @SerializedName("price")
    val price : String,
    @PrimaryKey(autoGenerate = true) val id : Int

)






