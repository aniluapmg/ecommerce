package com.example.ecommerce.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerce.databinding.FragmentProductBinding
import com.example.ecommerce.data.Product
import com.example.ecommerce.model.ProductViewModel
import com.example.ecommerce.model.retrofit.Servicio
import com.example.ecommerce.view.adapter.AdapterSearch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ProductFragment : Fragment() {

    private var productAdapter: AdapterSearch = AdapterSearch()
    private lateinit var binding: FragmentProductBinding
    private lateinit var recyclerView: RecyclerView
    private var products: List<Product> = listOf()
    private val productViewModel: ProductViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductBinding.inflate(inflater, container, false)
        recyclerView = binding.rvProduct
        recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = productAdapter // productAdapter sin ()
        conectarApi() // Llama a la API después de configurar el RecyclerView
        return binding.root
    }

    fun conectarApi() {
        val callObject = Servicio.getProduct.getProducts()

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
                        productAdapter.setListProducts(productos)
                        productAdapter.notifyDataSetChanged() // Notifica al adaptador sobre los cambios
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