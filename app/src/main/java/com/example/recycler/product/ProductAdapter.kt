package com.example.recycler.product

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SortedList
import com.example.recycler.MAIN
import com.example.recycler.R
import com.example.recycler.databinding.ProductLayoutBinding

class ProductAdapter: RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    val productList = SortedList(
        ProductModel::class.java,
        object : SortedList.Callback<ProductModel>() {
            override fun compare(o1: ProductModel, o2: ProductModel): Int {
                return o1.productName!!.compareTo(o2.productName!!)
            }

            override fun onInserted(position: Int, count: Int) {
                notifyItemRangeInserted(position, count)
            }

            override fun onRemoved(position: Int, count: Int) {
                notifyItemRangeRemoved(position, count)
            }

            override fun onMoved(fromPosition: Int, toPosition: Int) {
                notifyItemMoved(fromPosition, toPosition)
            }

            override fun onChanged(position: Int, count: Int) {
                notifyItemRangeChanged(position, count)
            }

            override fun areItemsTheSame(item1: ProductModel, item2: ProductModel): Boolean {
                return item1.art == item2.art
            }

            override fun areContentsTheSame(
                oldItem: ProductModel,
                newItem: ProductModel
            ): Boolean {
                return oldItem == newItem
            }

        })

    class ProductViewHolder(var binding: ProductLayoutBinding) : RecyclerView.ViewHolder(binding.root)

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

    fun chooseSecondary(holder: ProductViewHolder, product: ProductModel) {
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            ProductLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.binding.primaryInfo.removeAllViews()
        holder.binding.secondaryInfo.removeAllViews()

        if (true) {
            val tv = TextView(MAIN)
            tv.setTextAppearance(R.style.product_name)
            tv.text = productList[position].productName
            holder.binding.primaryInfo.addView(tv)
        }

        if (true) {
            val tv = TextView(MAIN)
            tv.setTextAppearance(R.style.product_art_text_style)
            tv.text = productList[position].art
            holder.binding.primaryInfo.addView(tv)
        }

        if (productList[position].description != null) {
            val tv = TextView(MAIN)
            tv.setTextAppearance(R.style.description_text_style)
            tv.setBackgroundResource(R.drawable.rounded_description_shape)
            tv.setCompoundDrawablesWithIntrinsicBounds(R.drawable.description_icon, 0, 0, 0)
            tv.setPadding(5, 5, 0, 5)
            tv.compoundDrawablePadding = 5
            tv.text = productList[position].description
            holder.binding.primaryInfo.addView(tv)
        }
        chooseSecondary(holder, productList[position])
    }

    override fun getItemCount(): Int {
        return productList.size()
    }

    fun addProduct(productModel: ProductModel) {
        productList.add(productModel)
    }

    fun replaceAll(products: MutableList<ProductModel>) {
        productList.beginBatchedUpdates()
        for (i in productList.size() - 1 downTo 0) {
            val product = productList[i]
            if (!products.contains(product)) {
                productList.remove(product)
            }
        }
        productList.addAll(products)
        productList.endBatchedUpdates()
    }
}