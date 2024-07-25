package com.example.ecommerce.view.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.ecommerce.R
import com.example.ecommerce.data.Product
import com.example.ecommerce.databinding.ActivityMainBinding
import com.example.ecommerce.network.Servicio
import com.example.ecommerce.view.fragments.LoginFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val loginFragment = LoginFragment()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        conectarApi()
        setCurrentFragment(loginFragment)
    }
    
    fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout, fragment)
            commit()
        }
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