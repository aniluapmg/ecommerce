package com.example.ecommerce.view.viewModel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

import com.example.ecommerce.model.model.ProductEntity
import com.example.ecommerce.model.retrofit.MyAPI
import com.example.ecommerce.model.retrofit.Servicio
import com.example.ecommerce.model.room.ProductDao
import com.example.ecommerce.model.room.ProductDatabase
import com.example.ecommerce.repository.ProductRepository
import com.example.ecommerce.repository.ProductRepositoryImp
import kotlinx.coroutines.flow.Flow

class ProductViewModel(application: Application) : ViewModel() {
    // ProductRepositoryImp viene como parametro para utilizarlo en el ViewModel y así poder acceder a sus funciones
    // Sin necesidad de crear una instancia de ProductRepositoryImp en el ViewModel
    // Todas las funciones del ViewModel se convierten a corrutinas ya que todas son asincronas


    val db = ProductDatabase.getDatabase(application)
    private val productDao: ProductDao = db.productDao()
    private val api  = Servicio().getProducts()
    private val productRepository = ProductRepositoryImp(api, productDao)


    suspend fun getProducts() = productRepository.getProducts()
    suspend fun getProductById(id: Int) = productRepository.getProductById(id)


}