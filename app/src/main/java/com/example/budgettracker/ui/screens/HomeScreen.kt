package com.example.budgettracker.ui.screens

import kotlin.OptIn
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Button
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.KeyboardType
import com.example.budgettracker.ui.components.SummaryCard
import com.example.budgettracker.viewmodel.GroceryViewModel
import com.example.budgettracker.ui.components.SetBudgetDialog
import androidx.compose.material3.OutlinedButton
import androidx.compose.ui.Alignment


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen (
    viewModel: GroceryViewModel
) {
    var itemName by rememberSaveable {
        mutableStateOf("")
    }

    var priceInput by rememberSaveable {
        mutableStateOf("")
    }

    var quantityInput by rememberSaveable {
        mutableStateOf("")
    }

    var errorMessage by remember {
        mutableStateOf("")

    }

    var showSetBudgetDialog by rememberSaveable {
        mutableStateOf(false)
    }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Grocery Budget Tracker")
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding).padding(16.dp)
        ) {
            SummaryCard(
                budget = viewModel.budget,
                spent = viewModel.totalSpent,
                remaining = viewModel.remainingBudget
            )
            Spacer (
                modifier = Modifier.height(24.dp)
            )
            OutlinedButton(
                onClick = {
                    showSetBudgetDialog = true
                },
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.size(150.dp,50.dp)
                    .align(Alignment.End)
            ) {
                Text("Edit Budget")
            }
            Spacer (
                modifier = Modifier.height(24.dp)
            )
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 1.dp
                )
            ) {
                Column (
                modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Add Grocery Item",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    OutlinedTextField(
                        value = itemName,
                        onValueChange = {
                            itemName = it
                        },
                        label = {
                            Text("Item Name")
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        OutlinedTextField(
                            value = priceInput,
                            onValueChange = {
                                priceInput = it
                            },
                            label = {
                                Text("Price")
                            },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                            modifier = Modifier.weight(2f)
                        )
                        OutlinedTextField(
                            value = quantityInput,
                            onValueChange = {
                                quantityInput = it
                            },
                            label = {
                                Text("Quantity")
                            },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                            modifier = Modifier.weight(1f)
                        )
                    }
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    Button(
                        onClick = {

                            if (
                                itemName.isBlank() || priceInput.isBlank() || quantityInput.isBlank()
                            ) {
                                errorMessage = "Please complete all the fields"
                                return@Button
                            }
                            viewModel.addItem(
                                name = itemName,
                                price = priceInput.toDoubleOrNull() ?: 0.0,
                                quantity = quantityInput.toIntOrNull() ?: 0
                            )
                            itemName = ""
                            priceInput = ""
                            quantityInput = ""
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Add item")
                    }
                }
            }
        }
    }
    if (showSetBudgetDialog) {
        SetBudgetDialog(
            onDismiss = { showSetBudgetDialog = false },
            onConfirm = { budget ->
                viewModel.updateBudget(budget)
                showSetBudgetDialog = false
            }
        )
    }
}