package com.example.ecommerce.repository

import com.example.ecommerce.data.Product
import com.example.ecommerce.model.model.ProductEntity
import com.example.ecommerce.model.retrofit.MyAPI
import com.example.ecommerce.model.retrofit.Servicio
import com.example.ecommerce.model.room.ProductDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class ProductRepositoryImp(
    private val call: Call<List<Product>>,
    // Retrofit viene implementado desde el constructor de la clase y no aquí
    private val productDao: ProductDao
    // ProductDao se trae desde parametro para poder acceder a la bbdd
) : ProductRepository {

    // Se agrego el cambio a corrutinas y tambien se le agrego el Flow ya que es una funcion asincrona
    // Al ser una funcion asincrona se quiere decir que puede tardar un tiempo en responder
    // productDao se usa para acceder a la bbdd y así poder usarlos

    //llamar a retrofit

    // Método para llamar a la API
    private suspend fun getProductsFromApi(): List<Product>? {
        // Llamada a la API utilizando Retrofit
        return withContext(Dispatchers.IO) {
            // Se usa withContext para cambiar el hilo de ejecución a un hilo de E/S
            // E/S es donde se hacen operaciones de entrada/salida, como la red o la base de datos
            // En este caso, se usa Dispatchers.IO para que la llamada a la API se realice en un hilo de E/S
            // Si no se usa withContext, la llamada a la API podría bloquear el hilo principal y/o tareas no podrian ejecutarse
            val call = Servicio().getProducts()
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

    //llamar a room


    override suspend fun getProducts(): List<ProductEntity> = productDao.getAll()

    override suspend fun getProductById(id: Int): List<ProductEntity> = productDao.getProductById(id)

    override suspend fun addProduct(productEntity: ProductEntity) = productDao.insertProduct(productEntity)

    override suspend fun updateProduct(productEntity: ProductEntity) = productDao.updateProduct(productEntity)

    override suspend fun deleteProduct(productEntity: ProductEntity) = productDao.deleteProduct(productEntity)


    // se agrega vinculación entre Retrofit y Room

    suspend fun refreshProducts()
    {
        val productsFromApi = getProductsFromApi()
        productsFromApi?.forEach {
            addProduct(ProductEntity(it.id, it.title, it.price, it.category, it.description, it.url))
        }
    }

}