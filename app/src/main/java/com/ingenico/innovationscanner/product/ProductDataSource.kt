package com.ingenico.innovationscanner.product

import com.ingenico.innovationscanner.R
import com.ingenico.innovationscanner.cart.CartItem

data class Product(val id: Int, val name: String, val barcode: String, val img: Int, val price: Float = 0f)

object ProductDataSource {
    val db = mutableListOf<Product>(
        Product(1, "Coca-cola 50oz", "Coke-1234", R.drawable.ic_empty_cart, 10.25f),
        Product(2, "Yoghurt Panchita", "Yoghurt-1234", R.drawable.ic_empty_cart, 4.1f),
        Product(3, "Nescafe 50oz", "Coffee-1234", R.drawable.ic_empty_cart, 5.5f),
        Product(4, "Tamales - Costeña", "Tamal-1234", R.drawable.ic_empty_cart, 11f),
        Product(5, "MnMs Icecream", "Icecream-1234", R.drawable.ic_empty_cart, 3.25f),
        Product(6, "Water Evian", "Water-1234", R.drawable.ic_empty_cart, 6f)
    )

    fun getProduct(barcode: String): Product? = db.find { product -> product.barcode == barcode }
}