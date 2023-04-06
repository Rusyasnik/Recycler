package com.example.recycler.product
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.coroutines.runBlocking
import retrofit2.http.GET

class ProductModel {
    var art: String? = null
    var productName: String? = null
    var flacon: String? = null
    var tuba: String? = null
    var cap: String? = null
    var dispenser: String? = null
    var jar: String? = null
    var glob: String? = null
    var envelope: String? = null
    var pencase: String? = null
    var description: String? = null
}