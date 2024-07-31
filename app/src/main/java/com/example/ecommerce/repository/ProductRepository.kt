package com.example.ecommerce.repository

import com.example.ecommerce.data.Product

interface ProductRepository {
    fun getProducts(): List<Product>
}