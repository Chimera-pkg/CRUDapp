package com.example.crudapp.ui.theme

import android.app.Application
import androidx.lifecycle.*
import com.example.crudapp.data.entity.Product
import com.example.crudapp.data.repository.ProductRepository
import com.example.crudapp.data.ProductDatabase
import kotlinx.coroutines.launch

class ProductViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ProductRepository
    val allProducts: LiveData<List<Product>>

    init {
        val productDao = ProductDatabase.getDatabase(application).productDao()
        repository = ProductRepository(productDao)
        allProducts = repository.allProducts
    }

    fun insert(product: Product) = viewModelScope.launch {
        repository.insert(product)
    }

    fun update(product: Product) = viewModelScope.launch {
        repository.update(product)
    }

    fun delete(product: Product) = viewModelScope.launch {
        repository.delete(product)
    }

    fun getProductById(productId: Int): LiveData<Product?> {
        val product = MutableLiveData<Product?>()
        viewModelScope.launch {
            product.value = repository.getProductById(productId)
        }
        return product
    }
}
