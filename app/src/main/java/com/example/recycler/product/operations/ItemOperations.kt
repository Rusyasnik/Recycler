package com.example.recycler.product.operations

import com.example.recycler.product.ProductModel

class ItemOperations {
    fun filter(products: List<ProductModel>, query: String): MutableList<ProductModel> {
        val filteredProductList = mutableListOf<ProductModel>()
        val lowerCaseQuery = query.lowercase()

        for (product in products) {
            val text = product.productName!!.lowercase()
            if (text.contains(lowerCaseQuery)) {
                filteredProductList.add(product)
            }
        }
        return filteredProductList
    }
}