package com.example.budgettracker.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.budgettracker.model.GroceryItem
import androidx.compose.ui.tooling.preview.Preview
import com.example.budgettracker.util.formatCurrency

@Composable
fun GroceryCard(
    item: GroceryItem,
    onDelete: () -> Unit
) {
    Card (
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row (
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                Text (
                    text = "${item.name} × ${item.quantity}",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text (
                    text = (formatCurrency(item.totalPrice)),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            IconButton(
                onClick = onDelete
            ) {
                Icon (
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete Item"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GroceryCardPreview() {
    GroceryCard(
        item = GroceryItem(
            id = 1,
            name = "Rice",
            price = 50.0,
            quantity = 2
        ),
        onDelete = {}
    )
}