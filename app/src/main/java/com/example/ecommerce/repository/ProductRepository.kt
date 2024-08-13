package com.example.ecommerce.repository

import com.example.ecommerce.data.Product

interface ProductRepository {
    fun getProducts(): List<Product>
    fun getProductById(id: Int): Product?
    fun addProduct(product: Product)
    fun updateProduct(product: Product)
    fun deleteProduct(id: Int)

}