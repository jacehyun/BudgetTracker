package com.example.budgettracker.navigation

//This helps to avoid bugs such as Typo on NavGraph
sealed class Screen(val route: String) {
    data object Home: Screen("home")
    data object GroceryList: Screen("grocery_list")
}