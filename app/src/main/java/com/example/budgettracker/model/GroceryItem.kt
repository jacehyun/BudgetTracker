package com.example.budgettracker.model

// This is for storing the data hehe
data class GroceryItem (
    val id: Int,
    val name: String,
    val price: Double,
    val quantity: Int
) { // Teaches the object to compute the total itself
    val totalPrice: Double
        get() = price * quantity
}