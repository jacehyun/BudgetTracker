package com.example.budgettracker.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.budgettracker.util.formatCurrency
import androidx.compose.material3.HorizontalDivider

@Composable
fun SummaryCard(
    budget: Double,
    spent: Double,
    remaining: Double,
    onUpdateBudget: (Double) -> Unit
) {
    var showSetBudgetDialog by rememberSaveable {
        mutableStateOf(false)
    }
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {
        Column (
           modifier = Modifier.padding(16.dp)
        ) {
            Text (
                text = "Budget Summary",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer (modifier = Modifier.height(16.dp))
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(10.dp).fillMaxWidth()
            ) {
                Text(
                    text = formatCurrency(remaining),
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )
                Text (
                    text = "Remaining"
                )
            }
            Spacer (modifier = Modifier.height(8.dp))
            HorizontalDivider(
                modifier = Modifier.padding(vertical = 8.dp),
                thickness = 1.dp,
                color = MaterialTheme.colorScheme.outlineVariant
            )
            Spacer (modifier = Modifier.height(8.dp))
            Row (
               horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Budget")
                Text(formatCurrency(budget))
            }
            Spacer (modifier = Modifier.height(8.dp))
            HorizontalDivider(
                modifier = Modifier.padding(vertical = 8.dp),
                thickness = 1.dp,
                color = MaterialTheme.colorScheme.outlineVariant
            )
            Spacer (modifier = Modifier.height(8.dp))
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Spent")
                Text(formatCurrency(spent))
            }
            Spacer (modifier = Modifier.height(8.dp))
            HorizontalDivider(
                modifier = Modifier.padding(vertical = 8.dp),
                thickness = 1.dp,
                color = MaterialTheme.colorScheme.outlineVariant
            )
            Spacer (modifier = Modifier.height(8.dp))
            OutlinedButton(
                onClick = {
                    showSetBudgetDialog = true
                },
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon (
                    imageVector = Icons.Outlined.Edit,
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Edit Budget")
            }
        }
    }
    if (showSetBudgetDialog) {
        SetBudgetDialog(
            onDismiss = { showSetBudgetDialog = false },
            onConfirm = { budget ->
                onUpdateBudget(budget)
                showSetBudgetDialog = false
            }
        )
    }
}