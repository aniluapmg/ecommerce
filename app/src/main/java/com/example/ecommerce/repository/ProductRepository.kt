package com.example.ecommerce.repository

import com.example.ecommerce.data.Product
import com.example.ecommerce.model.model.ProductEntity
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    // Se hizo el cambio a corrutinas a todas las funciones
    // Diferenciar que Product hacer referencia a data class del proyecto
    // y ProductEntity a la data class de la tabla de la bbdd
    suspend fun getProducts(): List<ProductEntity?>
    suspend fun getProductById(id: Int): List<ProductEntity?>
    suspend fun addProduct(productEntity: ProductEntity)
    suspend fun updateProduct(productEntity: ProductEntity)
    suspend fun deleteProduct(productEntity: ProductEntity)
}