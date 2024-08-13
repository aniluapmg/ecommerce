package com.example.ecommerce.view.viewModel

import androidx.lifecycle.ViewModel
import com.example.ecommerce.repository.ProductRepository
import com.example.ecommerce.repository.ProductRepositoryImp

class ProductViewModel : ViewModel() {
    private val productRepository : ProductRepository = ProductRepositoryImp()
    
    fun getProducts() = productRepository.getProducts()
    
    fun getProductById(id: Int) = productRepository.getProductById(id)
}