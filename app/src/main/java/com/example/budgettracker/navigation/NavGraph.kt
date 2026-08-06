package com.example.budgettracker.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.budgettracker.ui.components.BottomBar
import com.example.budgettracker.ui.screens.GroceryListScreen
import com.example.budgettracker.ui.screens.HomeScreen
import com.example.budgettracker.viewmodel.GroceryViewModel

@Composable
fun NavGraph (
    modifier: Modifier = Modifier
) {
    val navController =
        rememberNavController() //whenever button is pressed, this decides where to go
    val groceryViewModel: GroceryViewModel = viewModel()

    Scaffold(
        bottomBar = {BottomBar(navController = navController)}
    ) { innerPadding ->
        NavHost(
            navController = navController, //the controller for switching screens
            startDestination = Screen.GroceryList.route, //what shows when app starts
            modifier = modifier.padding(innerPadding)
        ) {
            composable(route = Screen.Home.route) {
                HomeScreen(viewModel = groceryViewModel)
            }
            composable(route = Screen.GroceryList.route) {
                GroceryListScreen(viewModel = groceryViewModel)
            }
        }
    }
}