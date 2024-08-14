package com.example.ecommerce.repository

import com.example.ecommerce.data.Product
import com.example.ecommerce.model.retrofit.Servicio
import com.example.ecommerce.model.room.ProductDao
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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
        //Chequear si hay productos en la base de datos
        //Si hay productos, devolverlos
        //Si no hay productos, obtenerlos de la API y devolverlos
        //Luego de obtenerlos de la API, guardarlos en la base de datos
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
    
    private fun getProductsFromApi(): List<Product> {
        val callObject = Servicio().getProducts()

        //si yo, callObject.enqueue, funciono, llamo a object.onResponse(call, response)
        //de lo contrario llamaré a object.onFailure(call, t)
        callObject.enqueue(object : Callback<List<Product>> {
            override fun onResponse(
                call: Call<List<Product>>,
                response: Response<List<Product>>
            ) {
                if (response.isSuccessful) {
                    val productos = response.body()
                    if (productos != null) {
                        //productAdapter.setListProducts(productos)
                        //productAdapter.notifyDataSetChanged() // Notifica al adaptador sobre los cambios
                    } else {
                        println("No se recibieron datos de productos")
                    }
                } else {
                    println("Error en la respuesta: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                println("Error en la llamada: ${t.message}")
            }
        })
        return emptyList()

    }
}