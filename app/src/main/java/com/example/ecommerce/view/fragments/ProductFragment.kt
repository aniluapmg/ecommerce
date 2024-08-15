package com.example.ecommerce.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerce.R
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

    // En los Fragment se usa el onCreateView en vez del onCreate,
    // es decir, al ser una vista la gran mayoría de sus funciones o métodos
    // estarán ubicadas en este espacio de código
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductBinding.inflate(inflater, container, false)
        //Generalmente, sólo se crean las instancias de funciones o metodos
        //Ya que de esta manera se evita sobrecargar el onCreateView y dejar sólo lo principal
        //De esta forma se logra desligar tareas al onCreateView
        startRecyclerView()
        getProducts()
        setupProductDetailNavigation()
        return binding.root
    }

    //Para inicializar el RecyclerView
    private fun startRecyclerView() {
        recyclerView = binding.rvProduct
        recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = productAdapter // productAdapter sin ()
    }

    //Se utiliza para navegar al detalle del producto
    private fun setupProductDetailNavigation() {
        productAdapter.onClick = { itemId ->
            val bundle = bundleOf("productId" to itemId)
            val productDetailFragment = ProductDetailFragment()
            productDetailFragment.arguments = bundle
            setCurrentFragment(productDetailFragment)
        }
    }

    //Se utiliza para cambiar al presente fragment
    private fun setCurrentFragment(fragment: Fragment) {
        requireActivity().supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout, fragment)
            commit()
        }
    }

    //Se obtiene los datos de los productos
    private fun getProducts() {
        //Es una corrutina.
        lifecycleScope.launch {
            val products = productViewModel.getProducts()
            productAdapter.setListProducts(products)
        }
    }
}