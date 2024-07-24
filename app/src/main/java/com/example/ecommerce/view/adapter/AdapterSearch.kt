package com.example.ecommerce.view.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerce.models.Product


class AdapterSearch(
    private val products: List<Product>
):RecyclerView.Adapter<AdapterSearch.ViewHolder>(){
    class ViewHolder (itemLayoutView: View):RecyclerView.ViewHolder(itemLayoutView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding =
    }

    override fun getItemCount(): Int {
        TODO("")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("")
    }

}