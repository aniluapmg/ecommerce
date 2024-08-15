package com.example.ecommerce.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerce.databinding.FragmentProductBinding
import com.example.ecommerce.view.adapter.AdapterSearch
import com.example.ecommerce.view.viewModel.ProductViewModel
import kotlinx.coroutines.launch

class ProductFragment : Fragment() {

    private var productAdapter: AdapterSearch = AdapterSearch()
    private lateinit var binding: FragmentProductBinding
    private lateinit var recyclerView: RecyclerView

    //Para fragment se usa by activityViewModels
    private val productViewModel: ProductViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductBinding.inflate(inflater, container, false)
        recyclerView = binding.rvProduct
        recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = productAdapter // productAdapter sin ()
        getProducts()
        return binding.root
    }

    private fun getProducts() {
        //Es una corrutina.
        lifecycleScope.launch {
            val products = productViewModel.getProducts()
            productAdapter.setListProducts(products)
        }

    }
}