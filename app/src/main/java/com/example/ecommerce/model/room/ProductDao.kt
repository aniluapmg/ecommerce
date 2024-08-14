package com.example.ecommerce.model.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.ecommerce.model.model.ProductEntity
import kotlinx.coroutines.flow.Flow

@Dao //anotación definida en room
interface ProductDao {
    @Query("SELECT * FROM products") //consulta a la BBDD (opera de forma local y offline)
    fun getAll(): List<ProductEntity>

    @Query("SELECT * FROM products WHERE id = :id")
    fun getProductById(id: Int): List<ProductEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(productEntity: ProductEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateProduct(productEntity: ProductEntity)
    
    @Delete
    suspend fun deleteProduct(productEntity: ProductEntity)

}