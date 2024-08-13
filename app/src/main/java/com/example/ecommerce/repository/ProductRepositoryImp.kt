package com.example.ecommerce.repository

import com.example.ecommerce.data.Product
import com.example.ecommerce.model.room.ProductDao
import kotlinx.coroutines.flow.Flow
import retrofit2.Retrofit

class ProductRepositoryImp(
//    private val retrofit: Retrofit
    // Retrofit viene implementado desde el constructor de la clase y no aquí
    private val productDao: ProductDao
    // ProductDao se trae desde parametro para poder acceder a la bbdd
) : ProductRepository {

    // Se agrego el cambio a corrutinas y tambien se le agrego el Flow ya que es una funcion asincrona
    // Al ser una funcion asincrona se quiere decir que puede tardar un tiempo en responder
    // productDao se usa para acceder a la bbdd y así poder usarlos

    override suspend fun getProducts(): Flow<List<Product>?> {
        TODO("Not yet implemented")
    }

    override suspend fun getProductById(id: Int): Flow<Product?> {
        TODO("Not yet implemented")
    }

    override suspend fun addProduct(product: Product) {
        TODO("Not yet implemented")
    }

    override suspend fun updateProduct(product: Product) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteProduct(id: Int) {
        TODO("Not yet implemented")
    }
    
    fun test() {
        println("Hola mundo")
    }
}