package com.example.recycler.retrofit

import ProductListRaw
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitServices {
    @GET("recycler/products")
    fun getItemList(): Call<ProductListRaw>
}