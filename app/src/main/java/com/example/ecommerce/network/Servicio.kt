package com.example.ecommerce.network

import android.widget.Toast
import com.example.ecommerce.models.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MyAPI {
    @GET("products")
    fun getProduct(): Call<Product>
}

class Servicio {
    val endPoint = "https://fakestoreapi.com/products"
    val retrofit = Retrofit.Builder().baseUrl(endPoint)
        .addConverterFactory(GsonConverterFactory.create()).build()

    fun conectarApi() {
        println(endPoint)
        println(retrofit)
        val api = retrofit.create(MyAPI::class.java)
        api.getProduct().enqueue(object : Callback<Product> {
            override fun onResponse(call: Call<Product>, response: retrofit2.Response<Product>) {

                if (
                    response.isSuccessful
                ) {
                    val responseData = response.body()
                }
                println(response.body()?.toString())
            }

            override fun onFailure(call: Call<Product>?, t: Throwable?) {
                println("Fallo conexion")
            }
        })

    }
}