package com.ingenico.innovationscanner.cart

import android.annotation.SuppressLint
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ingenico.innovationscanner.product.Product
import com.ingenico.innovationscanner.product.ProductDataSource

data class CartItem(val product: Product, var qt: Int = 1)

object CartDataSource {
    private lateinit var stateList: SnapshotStateList<CartItem>

    fun getItems() = stateList.toList()

    fun add(cartItem: CartItem) {
        stateList.add(cartItem)
    }

    fun searchToAdd(barcode: String) {
        val product = ProductDataSource.getProduct(barcode)
        if (product?.barcode == barcode) {
            val prevProd = stateList.find { item -> item.product.barcode == barcode }
            if (prevProd != null) prevProd.qt += 1
            else add(CartItem(product, 1))
        }
    }

    @SuppressLint("NewApi")
    fun remove(id: Int) {
        stateList.removeIf { f -> f.product.id == id }
    }

    fun totalItems(): Int = stateList.size

    fun totalAmount(): Float = stateList.map{cart -> cart.qt * cart.product.price}.reduce { acc, i -> acc + i  }

    fun registerCartItems(cartItems: SnapshotStateList<CartItem>) {
        stateList = cartItems;
    }

}