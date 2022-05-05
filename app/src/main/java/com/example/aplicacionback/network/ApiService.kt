package com.example.aplicacionback.network

import com.example.aplicacionback.Model.Producto
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("/productos")
    suspend fun getProducts(): List<Producto>

    companion object{
        var apiService:ApiService?=null
        fun getInstance(): ApiService{
            if(apiService==null)
            {
                apiService = Retrofit.Builder()
                    .baseUrl("http://localhost:3000")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiService::class.java)
            }
            return apiService!!
        }
    }
}