package com.example.ecommerce.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerce.model.model.Product
import com.example.ecommerce.databinding.ItemProductBinding


class AdapterSearch(

) : RecyclerView.Adapter<AdapterSearch.ViewHolder>() {

    private lateinit var binding: ItemProductBinding

    private lateinit var products: List<Product>

    inner class ViewHolder(itemLayoutView: View) : RecyclerView.ViewHolder(itemLayoutView) {
        fun onBind(product: Product) {
            binding.nameProduct.text = product.title
            binding.priceProduct.text = product.price.toString()
        }
    }

    fun setListProducts(products_response: List<Product>): List<Product> = products_response

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding.root)
    }

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.onBind(products[position])


}
