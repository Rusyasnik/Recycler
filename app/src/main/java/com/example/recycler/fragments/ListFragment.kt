package com.example.recycler.fragments

import ProductListRaw
import android.os.Bundle
import android.os.Handler
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.core.view.size
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycler.MAIN
import com.example.recycler.R
import com.example.recycler.databinding.FragmentListBinding
import com.example.recycler.fragments.operations.ErrorDialogBuilder
import com.example.recycler.fragments.operations.ViewOperations
import com.example.recycler.inc
import com.example.recycler.product.ProductAdapter
import com.example.recycler.product.ProductModel
import com.example.recycler.product.operations.ItemOperations
import com.example.recycler.retrofit.RetrofitClient
import com.example.recycler.retrofit.RetrofitServices
import kotlinx.coroutines.Runnable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Locale.filter


class ListFragment : Fragment() {

    lateinit var binding: FragmentListBinding
    private val adapter = ProductAdapter()

    private fun init(products: List<ProductModel>) {
        binding.apply {
            itemList.layoutManager = LinearLayoutManager(MAIN)
            itemList.adapter = adapter
            for (product in products) {
                adapter.addProduct(product)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(
            layoutInflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewOperations = ViewOperations()
        val itemOperations = ItemOperations()

        val retrofit = RetrofitClient.getClient()
        val productApi = retrofit.create(RetrofitServices::class.java)
        var products = mutableListOf<ProductModel>()


        binding.backgroundText.text = "Загрузка"
        binding.backgroundText.isVisible = true

        productApi.getItemList().enqueue(object : Callback<ProductListRaw> {
            override fun onResponse(
                call: Call<ProductListRaw>,
                response: Response<ProductListRaw>
            ) {
                products = response.body()?.products!!
                init(products)
                binding.backgroundText.isVisible = false
                binding.backgroundText.text = "???"
            }

            override fun onFailure(call: Call<ProductListRaw>, t: Throwable) {
                ErrorDialogBuilder().createDialog()
            }
        }
        )

        binding.lockButton.setOnClickListener {
            MAIN.navController.navigate(R.id.action_listFragment_to_FirstFragment)
        }

        binding.searchButton.setOnClickListener {
            viewOperations.switchVisibility(
                binding.itemSearch,
                binding.searchButton,
                binding.backgroundClicker
            )
        }

        binding.itemSearchInput.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                viewOperations.showKeyboard(binding.itemSearchInput)
                binding.amountChip.isVisible = false

                if (adapter.productList.size() == products.size) {
                    binding.itemSearchAmount.text = String.format(
                        resources.getString(R.string.total_amount_string),
                        adapter.productList.size()
                    )
                    binding.itemSearchClearButton.isVisible = false
                } else {
                    binding.itemSearchAmount.text = String.format(
                        resources.getString(R.string.search_amount_string),
                        adapter.productList.size()
                    )
                    binding.itemSearchClearButton.isVisible = true
                }
                binding.itemSearchAmount.isVisible = true

            } else {
                viewOperations.hideKeyboard(binding.itemSearchInput)
                viewOperations.buttonTextCorrector(
                    binding.itemSearchInput.text.toString(),
                    binding.searchButton
                )

                if (adapter.productList.size() > 0) {
                    binding.amountChip.setBackgroundResource(R.drawable.green_circle)
                    binding.amountChip.text = adapter.productList.size().toString()
                    binding.amountChip.isVisible = true
                } else {
                    binding.amountChip.setBackgroundResource(R.drawable.red_circle)
                    binding.amountChip.text = adapter.productList.size().toString()
                    binding.amountChip.isVisible = true
                }
            }
            if (adapter.productList.size() == products.size)
                binding.amountChip.isVisible = false
        }

        binding.itemSearch.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                viewOperations.switchVisibility(
                    binding.searchButton,
                    binding.itemSearch,
                    binding.backgroundClicker
                )
                return@OnKeyListener true
            }
            false
        })

        binding.itemSearchInput.doOnTextChanged { p0, _, _, count ->
            if (p0?.length == 0) {
                adapter.replaceAll(products)
                binding.itemList.scrollToPosition(0)
                binding.itemSearchAmount.text = String.format(
                    resources.getString(R.string.total_amount_string),
                    adapter.productList.size()
                )
                binding.itemSearchClearButton.isVisible = false
            } else {
                val filteredProductList = itemOperations.filter(
                    products,
                    p0.toString()
                )
                adapter.replaceAll(filteredProductList)
                binding.itemSearchAmount.text = String.format(
                    resources.getString(R.string.search_amount_string),
                    adapter.productList.size()
                )
                binding.itemSearchClearButton.isVisible = true
                binding.itemList.scrollToPosition(0)
            }
            binding.backgroundText.isVisible = adapter.productList.size() == 0
        }

        binding.backgroundClicker.setOnClickListener {
            viewOperations.switchVisibility(
                binding.searchButton,
                binding.itemSearch,
                binding.backgroundClicker
            )
        }

        binding.itemSearchClearButton.setOnClickListener {
            binding.itemSearchInput.text = null
            binding.itemSearchClearButton.isVisible = false
        }

        binding.constraintLayout.setOnClickListener{
            MAIN.stopHandler()
            MAIN.startHandler()
        }

        MAIN.startHandler()
    }
}