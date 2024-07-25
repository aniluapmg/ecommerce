package com.example.ecommerce.network

import com.example.ecommerce.data.Product
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MyAPI {
    @GET("products")
    fun getProducts(): Call<List<Product>>
}

object Servicio {
    val endPoint = "https://fakestoreapi.com/"

    val getProduct: MyAPI
        get() {
            val gson = GsonBuilder().setLenient().create()
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

            val retrofit = Retrofit.Builder().baseUrl(endPoint).client(client)
                .addConverterFactory(GsonConverterFactory.create(gson)).build()

            return retrofit.create(MyAPI::class.java)
        }
}


