package com.example.ecommerce

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ecommerce.models.Product
import com.example.ecommerce.network.Servicio
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        conectarApi()
    }

    fun conectarApi() {
        val callObject = Servicio.getProduct.getProducts()

        callObject.enqueue(object : Callback<List<Product>> {
            override fun onResponse(
                call: Call<List<Product>>,
                response: Response<List<Product>>
            ) {
                if (response.isSuccessful) {
                    val productos = response.body()
                    if (productos != null) {
                        for (producto in productos) {
                            println("Producto: ${producto.title}, Precio: ${producto.price}")
                        }
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

    }
}