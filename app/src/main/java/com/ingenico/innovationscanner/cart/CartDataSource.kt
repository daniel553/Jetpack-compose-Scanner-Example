package com.ingenico.innovationscanner.cart

import android.annotation.SuppressLint

data class CartItem(val id: Int, val name: String, val barcode: String, val img: String, val qt: Int = 0, val price: Float = 0f)

object CartDataSource {
    private val defaultList =  mutableListOf<CartItem>().also {
        it.addAll((0..10).map { CartItem(it, "Product", "Barcode", "IMG", it +1, it * 100f) })
    }

    fun getItems() = defaultList.toList()

    fun add(cartItem: CartItem) = defaultList.add(cartItem)

    @SuppressLint("NewApi")
    fun remove(id: Int) = defaultList.removeIf { f -> f.id == id }

}