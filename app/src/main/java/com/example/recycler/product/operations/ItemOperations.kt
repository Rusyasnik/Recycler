package com.example.recycler.product.operations

import android.view.LayoutInflater
import android.widget.TextView
import com.example.recycler.MAIN
import com.example.recycler.R
import com.example.recycler.product.ProductAdapter
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

    fun chooseSecondaryIcon(item: String): Int{
        val icon: Int?
        when {
            item == "C/LDPE" || item == "C/HDPE" -> icon = R.drawable.recycling_icon_0
            item == "PET" -> icon = R.drawable.recycling_icon_1
            item == "HDPE" -> icon = R.drawable.recycling_icon_2
            item == "LDPE" -> icon = R.drawable.recycling_icon_4
            item == "РР" -> icon = R.drawable.recycling_icon_5
            else -> icon = 0
        }
        return icon
    }

    fun chooseSecondary(holder: ProductAdapter.ProductViewHolder, product: ProductModel) {
        if (product.description != null) {
            val tv = TextView(MAIN)
            tv.setTextAppearance(R.style.description_text_style)
            tv.setBackgroundResource(R.drawable.rounded_description_shape)
            tv.setCompoundDrawablesWithIntrinsicBounds(R.drawable.description_icon, 0, 0, 0)
            tv.setPadding(5, 5, 0, 5)
            tv.compoundDrawablePadding = 5
            tv.text = product.description
            holder.binding.primaryInfo.addView(tv)
        }
        if (product.flacon != null) {
            val view = LayoutInflater.from(MAIN).inflate(R.layout.secondary_info_layout, null)
            val icon = chooseSecondaryIcon(product.flacon!!)
            val tv1 = view.findViewById<TextView>(R.id.tvSecondaryName)
            tv1.setTextAppearance(R.style.secondary_info_text_style)
            tv1.text = MAIN.resources.getString(R.string.secondary_flacon)
            val tv2 = view.findViewById<TextView>(R.id.tvSecondaryCode)
            tv2.setTextAppearance(R.style.secondary_info_text_style)
            tv2.text = product.flacon
            tv2.setCompoundDrawablesWithIntrinsicBounds(0, 0, icon, 0)
            holder.binding.secondaryInfo.addView(view)
        }
        if (product.tuba != null) {
            val view = LayoutInflater.from(MAIN).inflate(R.layout.secondary_info_layout, null)
            val icon = chooseSecondaryIcon(product.tuba!!)
            val tv1 = view.findViewById<TextView>(R.id.tvSecondaryName)
            tv1.setTextAppearance(R.style.secondary_info_text_style)
            tv1.text = MAIN.resources.getString(R.string.secondary_tuba)
            val tv2 = view.findViewById<TextView>(R.id.tvSecondaryCode)
            tv2.setTextAppearance(R.style.secondary_info_text_style)
            tv2.text = product.tuba
            tv2.setCompoundDrawablesWithIntrinsicBounds(0, 0, icon, 0)
            holder.binding.secondaryInfo.addView(view)
        }
        if (product.cap != null) {
            val view = LayoutInflater.from(MAIN).inflate(R.layout.secondary_info_layout, null)
            val icon = chooseSecondaryIcon(product.cap!!)
            val tv1 = view.findViewById<TextView>(R.id.tvSecondaryName)
            tv1.setTextAppearance(R.style.secondary_info_text_style)
            tv1.text = MAIN.resources.getString(R.string.secondary_cap)
            val tv2 = view.findViewById<TextView>(R.id.tvSecondaryCode)
            tv2.setTextAppearance(R.style.secondary_info_text_style)
            tv2.text = product.cap
            tv2.setCompoundDrawablesWithIntrinsicBounds(0, 0, icon, 0)
            holder.binding.secondaryInfo.addView(view)
        }
        if (product.dispenser != null){
            val view = LayoutInflater.from(MAIN).inflate(R.layout.secondary_info_layout, null)
            val icon = chooseSecondaryIcon(product.dispenser!!)
            val tv1 = view.findViewById<TextView>(R.id.tvSecondaryName)
            tv1.setTextAppearance(R.style.secondary_info_text_style)
            tv1.text = MAIN.resources.getString(R.string.secondary_dispenser)
            val tv2 = view.findViewById<TextView>(R.id.tvSecondaryCode)
            tv2.setTextAppearance(R.style.secondary_info_text_style)
            tv2.text = product.dispenser
            tv2.setCompoundDrawablesWithIntrinsicBounds(0, 0, icon, 0)
            holder.binding.secondaryInfo.addView(view)
        }
        if (product.jar != null){
            val view = LayoutInflater.from(MAIN).inflate(R.layout.secondary_info_layout, null)
            val icon = chooseSecondaryIcon(product.jar!!)
            val tv1 = view.findViewById<TextView>(R.id.tvSecondaryName)
            tv1.setTextAppearance(R.style.secondary_info_text_style)
            tv1.text = MAIN.resources.getString(R.string.secondary_jar)
            val tv2 = view.findViewById<TextView>(R.id.tvSecondaryCode)
            tv2.setTextAppearance(R.style.secondary_info_text_style)
            tv2.text = product.jar
            tv2.setCompoundDrawablesWithIntrinsicBounds(0, 0, icon, 0)
            holder.binding.secondaryInfo.addView(view)
        }
        if (product.glob != null){
            val view = LayoutInflater.from(MAIN).inflate(R.layout.secondary_info_layout, null)
            val icon = chooseSecondaryIcon(product.glob!!)
            val tv1 = view.findViewById<TextView>(R.id.tvSecondaryName)
            tv1.setTextAppearance(R.style.secondary_info_text_style)
            tv1.text = MAIN.resources.getString(R.string.secondary_glob)
            val tv2 = view.findViewById<TextView>(R.id.tvSecondaryCode)
            tv2.setTextAppearance(R.style.secondary_info_text_style)
            tv2.text = product.glob
            tv2.setCompoundDrawablesWithIntrinsicBounds(0, 0, icon, 0)
            holder.binding.secondaryInfo.addView(view)
        }
        if (product.envelope != null){
            val view = LayoutInflater.from(MAIN).inflate(R.layout.secondary_info_layout, null)
            val icon = chooseSecondaryIcon(product.envelope!!)
            val tv1 = view.findViewById<TextView>(R.id.tvSecondaryName)
            tv1.setTextAppearance(R.style.secondary_info_text_style)
            tv1.text = MAIN.resources.getString(R.string.secondary_envelope)
            val tv2 = view.findViewById<TextView>(R.id.tvSecondaryCode)
            tv2.setTextAppearance(R.style.secondary_info_text_style)
            tv2.text = product.envelope
            tv2.setCompoundDrawablesWithIntrinsicBounds(0, 0, icon, 0)
            holder.binding.secondaryInfo.addView(view)
        }
        if (product.pencase != null){
            val view = LayoutInflater.from(MAIN).inflate(R.layout.secondary_info_layout, null)
            val icon = chooseSecondaryIcon(product.pencase!!)
            val tv1 = view.findViewById<TextView>(R.id.tvSecondaryName)
            tv1.setTextAppearance(R.style.secondary_info_text_style)
            tv1.text = MAIN.resources.getString(R.string.secondary_pencase)
            val tv2 = view.findViewById<TextView>(R.id.tvSecondaryCode)
            tv2.setTextAppearance(R.style.secondary_info_text_style)
            tv2.text = product.pencase
            tv2.setCompoundDrawablesWithIntrinsicBounds(0, 0, icon, 0)
            holder.binding.secondaryInfo.addView(view)
        }
    }
}