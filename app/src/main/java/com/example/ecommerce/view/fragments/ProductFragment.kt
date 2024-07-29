package com.example.ecommerce.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ecommerce.data.Product
import com.example.ecommerce.databinding.FragmentProductBinding


import com.example.ecommerce.model.retrofit.Servicio
import com.example.ecommerce.view.adapter.AdapterSearch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class ProductFragment : Fragment() {

    private lateinit var productAdapter: AdapterSearch
    private lateinit var binding: FragmentProductBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        conectarApi()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductBinding.inflate(inflater, container, false)
        return binding.root

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
                    lateinit var products :  List<Product>
                    if (productos != null) {
                        for(p in productos){
                          println()
                        }
                        productAdapter.setListProducts(products)
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