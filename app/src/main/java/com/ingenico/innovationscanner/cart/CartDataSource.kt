package com.ingenico.innovationscanner.cart

import android.annotation.SuppressLint

data class CartItem(val id: Int, val name: String, val barcode: String, val img: String)

object CartDataSource {
    private val defaultList =  mutableListOf<CartItem>()

    fun getItems() = defaultList.toList()

    fun add(cartItem: CartItem) = defaultList.add(cartItem)

    @SuppressLint("NewApi")
    fun remove(id: Int) = defaultList.removeIf { f -> f.id == id }

}