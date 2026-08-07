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
import androidx.compose.foundation.layout.WindowInsets
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.ShoppingBasket
import androidx.compose.material3.Icon
import androidx.compose.material.icons.outlined.Numbers
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.filled.Add

import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

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
    Column(
            modifier = Modifier.fillMaxSize().padding(16.dp)
                .verticalScroll(rememberScrollState()) // let content scrolled up
                .imePadding() // push content above keyboard
        ) {
            SummaryCard(
                budget = viewModel.budget,
                spent = viewModel.totalSpent,
                remaining = viewModel.remainingBudget,
                onUpdateBudget = {viewModel.updateBudget(it)}
            )
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
                        leadingIcon = {
                            Icon (
                                imageVector = Icons.Outlined.ShoppingBasket,
                                contentDescription = "Shopping Icon"
                            )
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
                            leadingIcon = {
                              Text ( text = "₱", style = MaterialTheme.typography.titleLarge)
                            },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                            modifier = Modifier.weight(1f)
                        )
                        OutlinedTextField(
                            value = quantityInput,
                            onValueChange = {
                                quantityInput = it
                            },
                            label = {
                                Text("Quantity")
                            },
                            leadingIcon = {
                                Icon (
                                    imageVector = Icons.Outlined.Numbers,
                                    contentDescription = "Quantity"
                                )
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
