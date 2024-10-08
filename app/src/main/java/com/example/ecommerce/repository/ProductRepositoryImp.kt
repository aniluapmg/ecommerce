package com.example.ecommerce.repository

import com.example.ecommerce.EcommerceApp
import com.example.ecommerce.data.Product
import com.example.ecommerce.data.productEntityListToProductList
import com.example.ecommerce.data.productEntityToProduct
import com.example.ecommerce.data.toEntity
import com.example.ecommerce.model.retrofit.ProductResponse
import com.example.ecommerce.model.retrofit.Service
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductRepositoryImp : ProductRepository {

    override suspend fun getProducts(): List<Product> {
        //Chequear si hay productos en la base de datos
        //Si hay productos, devolverlos
        //Si no hay productos, obtenerlos de la API y devolverlos
        //Luego de obtenerlos de la API, guardarlos en la base de datos
        return withContext(Dispatchers.IO) {
            var productFromDatabase = EcommerceApp.database.productDao().getAll()
            if (productFromDatabase.isEmpty()) {
                val productFromApi = getProductsFromApi()
                productFromApi?.forEach {
                    EcommerceApp.database.productDao().insertProduct(it.toEntity())
                }
                productFromDatabase = EcommerceApp.database.productDao().getAll()
            }
            productEntityListToProductList(productFromDatabase)
        }
    }

    //Se obtiene un Productro a través de su id
    override suspend fun getProductById(id: Int): Product? {
        return withContext(Dispatchers.IO) {
            //Se usa withContext para cambiar el hilo de ejecución a un hilo de E/S
            //Se declara una variable donde se guarda la consulta hacia la bbdd
            val productFromDatabase = EcommerceApp.database.productDao().getProductById(id)
            //Luego entrega el ProductoEntity(Producto en la bbdd) transformado a uno Product(Producto para la UI)
            productFromDatabase?.let { productEntityToProduct(it) }
        }
    }

    override suspend fun addProduct(product: Product) {
        TODO("Not yet implemented")
    }

    override suspend fun updateProduct(product: Product) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteProduct(product: Product) {
        TODO("Not yet implemented")
    }

    // Método para llamar a la API
    private suspend fun getProductsFromApi(): List<ProductResponse>? {
        // Llamada a la API utilizando Retrofit
        return withContext(Dispatchers.IO) {
            // Se usa withContext para cambiar el hilo de ejecución a un hilo de E/S
            // E/S es donde se hacen operaciones de entrada/salida, como la red o la base de datos
            // En este caso, se usa Dispatchers.IO para que la llamada a la API se realice en un hilo de E/S
            // Si no se usa withContext, la llamada a la API podría bloquear el hilo principal y/o tareas no podrian ejecutarse
            val call = Service.getProduct.getProducts()
            // Se instancia una llamada (call) a la API que esta dentro de Servicio
            val response = call.execute()
            // Se realiza la llamada a la API y se espera una respuesta (response)
            if (response.isSuccessful) {
                // Si se obtiene una respuesta exitosa se obtiene el cuerpo de la respuesta
                response.body()
            } else {
                // Si no se obtiene una respuesta exitosa se imprime el código de error
                println("Error in Response: ${response.code()}")
                null
            }
        }
    }
}