package com.example.crudapp.data.repository


import androidx.lifecycle.LiveData
import com.example.crudapp.data.ProductDao
import com.example.crudapp.data.entity.Product

class ProductRepository(private val productDao: ProductDao) {

    val allProducts: LiveData<List<Product>> = productDao.getAllProducts()

    suspend fun insert(product: Product) {
        productDao.insert(product)
    }

    suspend fun update(product: Product) {
        productDao.update(product)
    }

    suspend fun delete(product: Product) {
        productDao.delete(product)
    }

    suspend fun getProductById(productId: Int): Product? {
        return productDao.getProductById(productId)
    }
}
