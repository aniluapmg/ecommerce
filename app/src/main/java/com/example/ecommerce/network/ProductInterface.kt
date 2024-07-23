
package com.example.ecommerce.network

import com.example.ecommerce.models.Product
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ProductInterface{

    @GET("products")
    fun getProducts(): Call<List<Product>>

}

object ApiClient {


    val BASE_URL = "https://fakestoreapi.com/"
    val getProduct: ProductInterface
        get()
        {
            //gson crear un objeto capaz de almacenar un Json
            val gson = GsonBuilder().setLenient().create()
            //crea una puerta de acceso al protocolo HTTP
            val interceptor =  HttpLoggingInterceptor()
            //mostrar toda la informacion de las llaves
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            //cliente es el en este caso el dispositivo Android/ en la web es el navegador
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

            val retrofit = Retrofit.Builder().baseUrl(BASE_URL).client(client)
                .addConverterFactory(GsonConverterFactory.create(gson)).build()

            return retrofit.create(ProductInterface::class.java)


        }



}