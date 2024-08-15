package com.example.ecommerce.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerce.R
import com.example.ecommerce.data.Product
import com.example.ecommerce.databinding.ItemProductBinding
import com.squareup.picasso.Picasso


class AdapterSearch(
    private var products: List<Product> = emptyList()
) : RecyclerView.Adapter<AdapterSearch.ViewHolder>() {

    var onClick: ((Int) -> Unit)? = null
    private lateinit var binding: ItemProductBinding

    inner class ViewHolder(itemLayoutView: View) : RecyclerView.ViewHolder(itemLayoutView) {
        // Inicialización de binding
        init {
            binding = ItemProductBinding.bind(itemLayoutView)
        }

        fun onBind(product: Product) {
            binding.nameProduct.text = product.title
            binding.priceProduct.text = product.price.toString()
            Picasso.get().load(product.url).into(binding.imgProduct) //mostramos la imagen recuperada con piccaso
            //Se obtiene del id del producto seleccionado
            val productId = product.id.toInt()
            binding.root.setOnClickListener {
                //La momento de hacer click se ejecuta la acción de cambiar a otro fragment
                //Y así se muestra el detalle del objeto seleccionado
                onClick?.invoke(productId)
            }
        }

    }

    fun setListProducts(productsResponse: List<Product>) {
        products = productsResponse
        notifyDataSetChanged()
    }

    /*override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding.root)
    }*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        )

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.onBind(products[position])


}
