package com.example.budgettracker.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
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
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.runtime.getValue


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavGraph (
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController() //whenever button is pressed, this decides where to go
    val groceryViewModel: GroceryViewModel = viewModel()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val topBarTitle = when (currentRoute) {
        Screen.Home.route -> "Grocery Budget Tracker"
        Screen.GroceryList.route -> "Grocery List"
        else -> "Grocery Budget Tracker"
    }

    Scaffold(
        topBar = {
            if (currentRoute == Screen.Home.route) {
                CenterAlignedTopAppBar(
                    title = {
                        Text(topBarTitle)
                    }
                )
            } else {
                TopAppBar(
                    title = {
                        Text(topBarTitle)
                    }
                )
            }
        },
        bottomBar = {
            BottomBar(navController = navController)
        }
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