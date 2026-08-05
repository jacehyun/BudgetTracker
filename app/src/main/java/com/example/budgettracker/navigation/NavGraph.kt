package com.example.budgettracker.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.budgettracker.ui.screens.GroceryListScreen
import com.example.budgettracker.ui.screens.HomeScreen
import com.example.budgettracker.ui.screens.StatsScreen
import com.example.budgettracker.viewmodel.GroceryViewModel

@Composable
fun NavGraph (
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController() //whenever button is pressed, this decides where to go
    val groceryViewModel: GroceryViewModel = viewModel()

    NavHost(
        navController = navController, //the controller for switching screens
        startDestination = Screen.Home.route, //what shows when app starts
        modifier = modifier //makes NavGraph Reusable
    ) {
        composable ( // route for the HomeScreen
            route = Screen.Home.route
        ) {
            HomeScreen (
                viewModel = groceryViewModel
            )
        }

        composable ( // route for the GroceryList
            route = Screen.GroceryList.route
        ) {
            GroceryListScreen (
                viewModel = groceryViewModel
            )
        }

        composable ( // route for the Stats
            route = Screen.Stats.route
        ) {
            StatsScreen(
                viewModel = groceryViewModel
            )
        }
    }
}