package com.example.crudapp.data.entity


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product_table")
data class Product(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val salePrice: Double?,
    val purchasePrice: Double?
)
