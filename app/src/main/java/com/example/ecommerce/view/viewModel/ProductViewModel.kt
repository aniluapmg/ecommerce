package com.example.ecommerce.view.viewModel

import androidx.lifecycle.ViewModel
import com.example.ecommerce.repository.ProductRepositoryImp

class ProductViewModel(private val productRepository: ProductRepositoryImp) : ViewModel() {
    // ProductRepositoryImp viene como parametro para utilizarlo en el ViewModel y así poder acceder a sus funciones
    // Sin necesidad de crear una instancia de ProductRepositoryImp en el ViewModel
    // Todas las funciones del ViewModel se convierten a corrutinas ya que todas son asincronas
    
    suspend fun getProducts() = productRepository.getProducts()
    
    suspend fun getProductById(id: Int) = productRepository.getProductById(id)



}