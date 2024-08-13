package com.example.ecommerce.repository

import com.example.ecommerce.data.Product
import com.example.ecommerce.model.room.ProductDao
import retrofit2.Retrofit

class ProductRepositoryImp(
//    private val retrofit: Retrofit, 
//    private val productDao: ProductDao
) : ProductRepository {
    
    override fun getProducts(): List<Product> {
        TODO("Not yet implemented")
    }

    override fun getProductById(id: Int): Product? {
        TODO("Not yet implemented")
    }

    override fun addProduct(product: Product) {
        TODO("Not yet implemented")
    }

    override fun updateProduct(product: Product) {
        TODO("Not yet implemented")
    }

    override fun deleteProduct(id: Int) {
        TODO("Not yet implemented")
    }
    
    fun test() {
        println("Hola mundo")
    }
}