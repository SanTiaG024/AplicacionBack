package com.example.aplicacionback.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aplicacionback.Model.Producto
import com.example.aplicacionback.network.ApiService
import com.example.aplicacionback.network.ApiService.Companion.apiService
import kotlinx.coroutines.launch

class ProductoViewModel:ViewModel() {
    var productlistResponse:List<Producto> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")

    fun getproductlist() {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                val productlList = apiService.getProducts()
                productlistResponse = productlList
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}