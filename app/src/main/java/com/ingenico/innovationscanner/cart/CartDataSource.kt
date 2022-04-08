package com.ingenico.innovationscanner.cart

import android.annotation.SuppressLint
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ingenico.innovationscanner.product.Product
import com.ingenico.innovationscanner.product.ProductDataSource

data class CartItem(val product: Product, var qt: Int = 1)

object CartDataSource {
    private val defaultList = mutableListOf<CartItem>(CartItem(ProductDataSource.getRandomProduct()))
    var stateList by mutableStateOf(defaultList.toList())

    fun getItems() = defaultList

    fun add(cartItem: CartItem) {
        defaultList.add(cartItem)
        update()
    }

    fun searchToAdd(barcode: String) {
        val product = ProductDataSource.getProduct(barcode)
        if (product?.barcode == barcode) {
            val prevProd = defaultList.find { item -> item.product.barcode == barcode }
            if (prevProd != null) prevProd.qt += 1
            else add(CartItem(product, 1))
        }
    }

    @SuppressLint("NewApi")
    fun remove(id: Int) {
        defaultList.removeIf { f -> f.product.id == id }
        update()
    }

    private fun update() {
        stateList = defaultList.toList()
    }

    fun totalItems(): Int = defaultList.size

    fun totalAmount(): Float = defaultList.map{cart -> cart.qt * cart.product.price}.reduce { acc, i -> acc + i  }

}