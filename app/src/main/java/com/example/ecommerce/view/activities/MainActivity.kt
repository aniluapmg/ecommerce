package com.example.ecommerce.view.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.room.Room
import com.example.ecommerce.R
import com.example.ecommerce.data.Product
import com.example.ecommerce.databinding.ActivityMainBinding
import com.example.ecommerce.model.room.ProductDatabase
import com.example.ecommerce.repository.ProductRepositoryImp
import com.example.ecommerce.view.fragments.LoginFragment
import com.example.ecommerce.view.viewModel.ProductViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: ProductViewModel
    lateinit var binding: ActivityMainBinding
    private val loginFragment = LoginFragment()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            //prueba funcionamiento con la bd
            val db = ProductDatabase.getDatabase(applicationContext)
            // Realiza operaciones con la base de datos aquí
            db.productDao().getAll()
        } catch (e: Exception) {
            e.message
        }



        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setCurrentFragment(loginFragment)


    }


    
    fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout, fragment)
            commit()
        }
    }
}