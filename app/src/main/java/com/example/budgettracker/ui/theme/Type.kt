package com.example.budgettracker.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.Font
import com.example.budgettracker.R


val Figtree = FontFamily(
    // Regular (upright) weights
    Font(R.font.figtree_light, FontWeight.Light),
    Font(R.font.figtree_regular, FontWeight.Normal),
    Font(R.font.figtree_medium, FontWeight.Medium),
    Font(R.font.figtree_semibold, FontWeight.SemiBold),
    Font(R.font.figtree_bold, FontWeight.Bold),
    Font(R.font.figtree_extrabold, FontWeight.ExtraBold),
    Font(R.font.figtree_black, FontWeight.Black),

    // Italic weights
    Font(R.font.figtree_lightitalic, FontWeight.Light, FontStyle.Italic),
    Font(R.font.figtree_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.figtree_mediumitalic, FontWeight.Medium, FontStyle.Italic),
    Font(R.font.figtree_semibolditalic, FontWeight.SemiBold, FontStyle.Italic),
    Font(R.font.figtree_bolditalic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.figtree_extrabolditalic, FontWeight.ExtraBold, FontStyle.Italic),
    Font(R.font.figtree_blackitalic, FontWeight.Black, FontStyle.Italic)
)
// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = Figtree,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleMedium = TextStyle(
        fontFamily = Figtree,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
        lineHeight = 24.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = Figtree,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),
    titleLarge = TextStyle(
        fontFamily = Figtree,
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
        lineHeight = 28.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = Figtree,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
        lineHeight = 32.sp
    ),
    labelLarge = TextStyle(
        fontFamily = Figtree,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    )
)