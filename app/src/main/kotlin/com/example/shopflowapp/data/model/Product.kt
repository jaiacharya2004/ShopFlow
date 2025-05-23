package com.example.shopflowapp.data.model


data class Product(
    val name: String,
    val price: Double,          // discounted price
    val imageResId: Int,
    val originalPrice: Double? = null  // new field for original price (cut line)
)

