package com.example.ecommerce.model.room

import androidx.room.Dao
import androidx.room.Query
import com.example.ecommerce.model.model.ProductEntity

@Dao //anotación definida en room
interface ProductDao {
    @Query("SELECT * FROM products") //consulta a la BBDD (opera de forma local y offline)
    fun getAll(): List<ProductEntity>
}