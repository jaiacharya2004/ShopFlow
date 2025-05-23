package com.example.shopflowapp.data.repository


import com.example.shopflowapp.R
import com.example.shopflowapp.data.model.Product

class ProductRepository {

    // Helper to calculate discounted price after 20% off
    private fun getDiscountedPrice(originalPrice: Double): Double {
        return (originalPrice * 0.8)
    }

    fun getProducts(): List<Product> {
        val shoeOriginalPrice = 444.00
        val watchOriginalPrice = 444.00

        return listOf(
            Product(
                name = "Stylish Shoes",
                originalPrice = shoeOriginalPrice,
                price = 355.20, // discounted price shown first
                imageResId = R.drawable.product_image
            ),
            Product(
                name = "Classic Watch",
                originalPrice = watchOriginalPrice,
                price = 355.20, // discounted price shown first
                imageResId = R.drawable.categorysample
            ),
            Product(
                name = "Stylish Shoes",
                originalPrice = shoeOriginalPrice,
                price = 355.20, // discounted price shown first
                imageResId = R.drawable.product_image
            ),
        )
    }
}
