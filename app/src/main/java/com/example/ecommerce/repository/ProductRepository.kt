package com.example.ecommerce.repository

import com.example.ecommerce.data.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    // Se hizo el cambio a corrutinas a todas las funciones
    // Diferenciar que Product hacer referencia a data class del proyecto
    // y ProductEntity a la data class de la tabla de la bbdd
    suspend fun getProducts(): Flow<List<Product>?>
    suspend fun getProductById(id: Int): Flow<Product?>
    suspend fun addProduct(product: Product)
    suspend fun updateProduct(product: Product)
    suspend fun deleteProduct(id: Int)
}