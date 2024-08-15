package com.example.ecommerce.data

import com.example.ecommerce.model.model.ProductEntity
import com.example.ecommerce.model.retrofit.ProductResponse

//Transforma un ProductResponse (Producto desde la API) a un ProductEntity (Producto en la ddbb)
fun ProductResponse.toEntity(): ProductEntity = ProductEntity(
    idProducto = id,
    title = title,
    price = price,
    category = category,
    description = description,
    url = url
)

//Transforma un ProductEntity (Producto en la ddbb) a un Product (Producto en la UI)
fun productEntityToProduct(productEntity: ProductEntity): Product = Product(
    id = productEntity.idProducto,
    title = productEntity.title,
    price = productEntity.price,
    category = productEntity.category,
    description = productEntity.description,
    url = productEntity.url
)

//Tranforma una lista de ProductEntity (Producto en la ddbb) a una lista de Product (Producto en la UI)
fun productEntityListToProductList(list: List<ProductEntity>): List<Product> =
    list.map(::productEntityToProduct)