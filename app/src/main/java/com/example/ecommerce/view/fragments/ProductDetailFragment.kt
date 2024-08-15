package com.example.ecommerce.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.ecommerce.R
import com.example.ecommerce.data.Product
import com.example.ecommerce.databinding.FragmentProductDetailBinding
import com.example.ecommerce.view.viewModel.ProductViewModel
import com.squareup.picasso.Picasso
import kotlinx.coroutines.launch

class ProductDetailFragment : Fragment() {
    //El _binding se inicializa en null ya que un producto puede o no puede existir
    private var _binding: FragmentProductDetailBinding? = null
    //El binding obtiene una doble negacion (!!) del valor _binding
    private val binding get() = _binding!!
    //Para fragment se usa by activityViewModels
    private val productDetailViewModel: ProductViewModel by activityViewModels()
    private val productFragment = ProductFragment()

    // En los Fragment se usa el onCreateView en vez del onCreate,
    // es decir, al ser una vista la gran mayoría de sus funciones o métodos
    // estarán ubicadas en este espacio de código
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Se inicializa una variable
        //Para obtener como valor recibido a través del bundle
        //Del fragment anterior
        val productId = arguments?.getInt("productId", -1) ?: -1
        _binding = FragmentProductDetailBinding.inflate(inflater, container, false)
        //Generalmente, sólo se crean las instancias de funciones o metodos
        //Ya que de esta manera se evita sobrecargar el onCreateView y dejar sólo lo principal
        //De esta forma se logra desligar tareas al onCreateView
        getProductData(productId)
        backButton()
        return binding.root
    }

    //Se obtiene la data del Producto con ayuda del id obtenido inicialmente
    private fun getProductData(id: Int) {
        lifecycleScope.launch {
            //Hace la consulta, verificando que el valor inicial no sea el mismo que el valor
            //Obtenido a través del bundle
            if (id != -1) {
                //Con el valor del id se hace la consulta del objeto Producto en la bbdd
                //Y posterior mente se guarda en una variable
                val productUI = productDetailViewModel.getProductById(id)
                if (productUI != null) {
                    //Luego de cumplirse de manera existosa se pasan los datos
                    //al updateUI que cumple como función pasar los datos a la UI
                    updateUI(productUI)
                } else {
                    println("Error: Product data is null")
                }
            } else {
                println("Error: Product ID is invalid")
            }
        }
    }

    //Se encaga de mostrar los datos en la UI
    private fun updateUI(product: Product) {
        binding.nameProduct.text = product.title
        binding.priceProduct.text = "Price: $${product.price}"
        binding.descriptionProduct.text = product.description
        binding.categoryProduct.text = product.category
        Picasso.get().load(product.url).into(binding.imgProduct)
    }

    //Su función es de retrocer página al momento de hacer click
    private fun backButton() {
        binding.imgBtnBack.setOnClickListener {
            setCurrentFragment(productFragment)
        }
    }

    //Se utiliza para cambiar al presente fragment
    private fun setCurrentFragment(fragment: Fragment) {
        requireActivity().supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout, fragment)
            commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}