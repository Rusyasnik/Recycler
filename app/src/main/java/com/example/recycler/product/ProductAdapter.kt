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
import com.example.recycler.fragments.operations.ViewOperations
import com.example.recycler.product.operations.ItemOperations

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            ProductLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.binding.primaryInfo.removeAllViews()
        holder.binding.secondaryInfo.removeAllViews()

        val tv1 = TextView(MAIN)
        tv1.setTextAppearance(R.style.product_name)
        tv1.text = productList[position].productName
        holder.binding.primaryInfo.addView(tv1)

        val tv2 = TextView(MAIN)
        tv2.setTextAppearance(R.style.product_art_text_style)
        tv2.text = productList[position].art
        holder.binding.primaryInfo.addView(tv2)

        val itemOperations = ItemOperations()
        itemOperations.chooseSecondary(holder, productList[position])
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