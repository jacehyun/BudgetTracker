package com.example.budgettracker.ui.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Numbers
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun SetBudgetDialog (
    onDismiss: () -> Unit,
    onConfirm: (budget: Double) -> Unit
) {
    var budgetInput by rememberSaveable {
        mutableStateOf("")
    }
    AlertDialog(
      onDismissRequest = onDismiss,
        title = {
            Text("Set Budget")
        },
        text = {
            OutlinedTextField(
                value = budgetInput,
                onValueChange =  { budgetInput = it},
                label = { Text ("Budget")},
                leadingIcon = {
                    Text ( text = "₱", style = MaterialTheme.typography.titleLarge)
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
            )
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirm(budgetInput.toDoubleOrNull() ?: 0.0)
                }
            ) {
                Text("Set")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}