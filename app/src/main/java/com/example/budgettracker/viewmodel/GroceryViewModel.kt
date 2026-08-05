package com.example.budgettracker.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.budgettracker.model.GroceryItem

// Handles the storing of groceries, budget, and IDs
class GroceryViewModel : ViewModel() {
    private val _groceryList = mutableStateListOf<GroceryItem>() //When the list changes, it refreshes the UI

    val groceryList: List<GroceryItem>
        get() = _groceryList
    //lets only the ViewModel to change budget
    var budget by mutableDoubleStateOf(0.0)
        private set

    private var nextId by mutableIntStateOf(1)

    fun updateBudget(newBudget: Double) {
        if (newBudget >= 0) {
            budget = newBudget
        }
    }

    fun addItem (
        name: String,
        price: Double,
        quantity: Int
    ) {
        if (
            name.isBlank() || price <= 0 || quantity <= 0 //prevents bugs
        ) return

        val item = GroceryItem(
            id = nextId++,
            name = name.trim(),
            price = price,
            quantity = quantity
        )
        _groceryList.add(item)
    }

    fun deleteItem(id: Int) {
        _groceryList.removeIf { item ->
            item.id == id
        }
    }

    fun clearItems() {
        _groceryList.clear()
    }

    val totalSpent: Double
        get() = groceryList.sumOf { it.totalPrice}

    val remainingBudget: Double
        get() = budget - totalSpent

    val totalItems: Int
        get() = groceryList.size
}