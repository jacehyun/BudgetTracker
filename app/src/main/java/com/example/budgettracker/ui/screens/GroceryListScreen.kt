package com.example.budgettracker.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import com.example.budgettracker.ui.components.GroceryCard
import com.example.budgettracker.viewmodel.GroceryViewModel

@Composable
fun GroceryListScreen (
    viewModel: GroceryViewModel
) {
    Scaffold { innerPadding ->
        if (viewModel.groceryList.isEmpty()) {
            Text (
                text = "No Items Added Yet!",
                modifier = Modifier.padding(innerPadding)
            )
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items (
                    items = viewModel.groceryList,
                    key = { it.id }
                ) { item ->
                    GroceryCard(
                        item = item,
                        onDelete = { viewModel.deleteItem(item.id)}
                    )
                }
            }
        }
    }

}