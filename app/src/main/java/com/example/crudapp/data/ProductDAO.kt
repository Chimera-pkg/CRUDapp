package com.example.crudapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.crudapp.data.entity.Product

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(product: Product)

    @Update
    suspend fun update(product: Product)

    @Delete
    suspend fun delete(product: Product)

    @Query("SELECT * FROM product_table ORDER BY name ASC")
    fun getAllProducts(): LiveData<List<Product>>

    @Query("SELECT * FROM product_table WHERE id = :productId")
    suspend fun getProductById(productId: Int): Product?
}
