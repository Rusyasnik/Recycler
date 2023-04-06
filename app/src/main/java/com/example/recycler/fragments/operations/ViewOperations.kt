package com.example.recycler.fragments.operations

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycler.MAIN
import com.example.recycler.R
import com.example.recycler.SEARCH_MAX_SYMBOLS
import com.example.recycler.databinding.FragmentListBinding
import com.example.recycler.inc
import com.example.recycler.product.ProductAdapter
import com.example.recycler.product.ProductModel

class ViewOperations () {

    private val imm = MAIN.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

    fun showKeyboard(view: View) {
        imm.showSoftInput(view, 0)
    }

    fun hideKeyboard(view: View) {
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    fun switchVisibility(view1: View, view2: View, viewBackground: View) {
        view1.isVisible++
        view2.isVisible++
        viewBackground.isVisible++
        view1.requestFocus()
    }

    fun buttonTextCorrector(itemSearch: String, searchButton: Button) {
        if (itemSearch.length > SEARCH_MAX_SYMBOLS)
            searchButton.text = buildString {
            append(itemSearch.take(SEARCH_MAX_SYMBOLS))
            append("...")
        }
        else if (itemSearch != "")
            searchButton.text = itemSearch
        else searchButton.text = MAIN.resources?.getText(R.string.headline_base_string)
    }
}
