package com.example.budgettracker.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.runtime.getValue
import com.example.budgettracker.navigation.Screen

@Composable
fun BottomBar(
    navController: NavController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val items = listOf (
        Triple(Screen.Home, Icons.Default.Home, "Home"),
        Triple(Screen.GroceryList, Icons.Default.List, "Groceries"),
    )

    NavigationBar {
        items.forEach { (screen, icon, label) ->
            NavigationBarItem(
                selected = currentRoute == screen.route,
                onClick =  {
                    navController.navigate(screen.route) {
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(imageVector = icon, contentDescription = label)
                },
                label = {
                    Text(label)
                }
            )
        }
    }
}