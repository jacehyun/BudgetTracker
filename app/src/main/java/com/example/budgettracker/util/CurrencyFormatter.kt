package com.example.budgettracker.util

import java.text.NumberFormat
import java.util.Locale

fun formatCurrency (amount: Double): String {
    val formatter = NumberFormat.getNumberInstance(Locale("en", "PH"))
    formatter.minimumFractionDigits = 2
    formatter.maximumFractionDigits = 2
    return "₱${formatter.format(amount)}"
}